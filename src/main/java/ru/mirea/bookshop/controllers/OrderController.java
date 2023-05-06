package ru.mirea.bookshop.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mirea.bookshop.entities.Order;
import ru.mirea.bookshop.entities.User;
import ru.mirea.bookshop.services.interfaces.OrderService;
import ru.mirea.bookshop.services.interfaces.UserService;


@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping("/create_order")
    public String createOrder(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        if (user != null) {
            Order order = new Order(user, user.getCart());
            user.getCart().clear();
            user.getOrders().add(order);
            userService.update(user);
            orderService.add(order);
            model.addAttribute("message", "Заказ успешно сформирован!");
            model.addAttribute("cart_list", user.getCart());
            return "cart";
        } else {
            model.addAttribute("message", "Сначана войдите!");
            return "login";
        }
    }

    @GetMapping("/{id}")
    public String showOrder(@PathVariable(name = "id") Long id, Model model) {
        try {
            model.addAttribute("order", orderService.getOrder(id));
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "orderpage";
    }
}
