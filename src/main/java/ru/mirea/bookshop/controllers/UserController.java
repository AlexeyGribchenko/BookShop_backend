package ru.mirea.bookshop.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mirea.bookshop.entities.User;
import ru.mirea.bookshop.services.interfaces.BookService;
import ru.mirea.bookshop.services.interfaces.UserService;

@Controller
@RequestMapping("/profile")
public class UserController {

    private final UserService userService;
    private final BookService bookService;

    public UserController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping()
    public String showInfo(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("isLogined", true);
        } else {
            model.addAttribute("isLogined", false);
        }
        return "profile";
    }

    @GetMapping("/cart")
    public String showCart(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        if (user != null) {
            model.addAttribute("cart_list", user.getCart());
        } else {
            model.addAttribute("message", "Вы не вошли!");
        }
        return "cart";
    }

    @GetMapping("/wishlist")
    public String showWishList(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        if (user != null) {
            model.addAttribute("wishlist", user.getWishList());
        } else {
            model.addAttribute("message", "Вы не вошли!");
        }
        return "wishlist";
    }

    @GetMapping("/orders")
    public String showOrders(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        if (user != null) {
            model.addAttribute("order_list", user.getOrders());
        } else {
            model.addAttribute("message", "Вы не вошли!");
        }
        return "orders";
    }

    @GetMapping("/delete")
    public String delete(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        userService.remove(user.getId());
        return "redirect:/profile/logout";
    }
}
