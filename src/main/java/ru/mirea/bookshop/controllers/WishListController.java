package ru.mirea.bookshop.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mirea.bookshop.entities.Book;
import ru.mirea.bookshop.entities.User;
import ru.mirea.bookshop.services.interfaces.BookService;
import ru.mirea.bookshop.services.interfaces.UserService;

@Controller
@RequestMapping("/wishlist")
public class WishListController {

    private final BookService bookService;
    private final UserService userService;

    public WishListController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @PostMapping("/add/{id}")
    public String add(
            @AuthenticationPrincipal User user,
            @PathVariable(name = "id") Long id,
            Model model
    ) {
        try {
            Book book = bookService.getBook(id);
            if (!user.getWishList().contains(book)) {
                user.getWishList().add(book);
                userService.update(user);
            }
            return String.format("redirect:/book/%d", book.getId());
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", "Ошибка!");
            return "main";
        }
    }

    @PostMapping("/remove/{id}")
    public String remove(
            @PathVariable(name = "id") Long id,
            @AuthenticationPrincipal User user,
            Model model
    ) {
        try {
            Book book = bookService.getBook(id);
            user.getWishList().remove(book);
            userService.update(user);
            return "redirect:/profile/wishlist";
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", "Ошибка!");
            return "main";
        }
    }
}
