package ru.mirea.bookshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mirea.bookshop.entities.Book;
import ru.mirea.bookshop.services.interfaces.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book_form", new Book());
        return "add_book_form";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book_form") Book book, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "add_book_form";
        }
        bookService.add(book);
        model.addAttribute("message", "Книга успешно добавлена!");
        return "add_book_form";
    }

    @GetMapping("/{id}")
    public String getBookPage(@PathVariable(name = "id") Long id, Model model) {
        try {
            Book book = bookService.getBook(id);
            model.addAttribute("book", book);
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", "Извините, книга не найдена :(");
        }
        return "book_page";
    }
}
