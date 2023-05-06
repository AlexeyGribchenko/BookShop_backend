package ru.mirea.bookshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mirea.bookshop.services.interfaces.BookService;

@Controller
public class MainController {

    private final BookService bookService;

    public MainController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String start(Model model) {
        model.addAttribute("book_list", bookService.getAll());
        return "main";
    }
}
