package ru.mirea.bookshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.bookshop.entities.Book;
import ru.mirea.bookshop.services.interfaces.BookService;

@Controller
public class MainController {

    private final BookService bookService;

    public MainController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String start(Model model) {
        model.addAttribute("bookList", bookService.getAll());
        return "main";
    }

    @GetMapping("/book_page/{id}")
    public String getBookPage(
            @PathVariable(name = "id") Long id,
            Model model
    ) {
        try {
            Book book = bookService.getBook(id);
            model.addAttribute("book", book);
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", "Извините, книга не найдена :(");
        }
        return "book_page";
    }

    @GetMapping("/search_books")
    public String searchBooks(
            @RequestParam(name = "searchPrompt") String searchPrompt,
            Model model
    ) {
        model.addAttribute("bookList", bookService.search(searchPrompt));
        return "main";
    }

    @GetMapping("/error")
    public String showErrorPage() {
        return "error_page";
    }
}
