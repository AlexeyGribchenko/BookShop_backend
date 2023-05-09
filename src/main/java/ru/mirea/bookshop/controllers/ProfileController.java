package ru.mirea.bookshop.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mirea.bookshop.entities.Order;
import ru.mirea.bookshop.entities.User;
import ru.mirea.bookshop.services.interfaces.BookService;
import ru.mirea.bookshop.services.interfaces.UserService;

import java.util.Comparator;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showInfo(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        model.addAttribute("user", user);
        if (user != null) {
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
            model.addAttribute("order_list", user.getOrders().stream()
                    .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                    .toList());
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
