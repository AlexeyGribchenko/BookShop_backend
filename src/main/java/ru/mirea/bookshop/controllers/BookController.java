package ru.mirea.bookshop.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.mirea.bookshop.entities.Book;
import ru.mirea.bookshop.services.interfaces.BookService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/book")
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
public class BookController {

    @Value("${upload.path}")
    private String uploadPath;

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("bookList", bookService.getAll());
        model.addAttribute("bookForm", new Book());
        return "books_admin";
    }

    @PostMapping("/add")
    public String addBook(
            @ModelAttribute("bookForm") Book book,
            @RequestParam MultipartFile file,
            BindingResult bindingResult,
            Model model) throws IOException {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "books_admin";
        }

        if (!file.isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/static/img/" + resultFileName));

            book.setImgName(resultFileName);
        } else {
            book.setImgName("default_book_img.png");
        }

        bookService.add(book);
        model.addAttribute("message", "Книга успешно добавлена!");
        model.addAttribute("bookForm", new Book());
        model.addAttribute("bookList", bookService.getAll());
        return "books_admin";
    }
}
