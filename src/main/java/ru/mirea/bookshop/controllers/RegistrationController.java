package ru.mirea.bookshop.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.bookshop.entities.User;
import ru.mirea.bookshop.services.interfaces.UserService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@PreAuthorize("hasAnyAuthority('ROLE_USER')")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String register(Model model) {
        model.addAttribute("user_form", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @ModelAttribute("user_form") User user,
            @RequestParam(name = "birthDateString") String birthDateString,
            BindingResult bindingResult,
            Model model
            ) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "registration";
        }
        try {
            user.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse(birthDateString));
        } catch (ParseException e) {
            user.setBirthDate(null);
        }
        if (!userService.add(user)) {
            model.addAttribute("message", "Ползователь с таким логином уже существует!");
            return "registration";
        }
        model.addAttribute("message", "Успешная регистрация!");
        return "login";
    }
}
