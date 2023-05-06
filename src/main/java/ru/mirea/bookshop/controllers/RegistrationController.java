package ru.mirea.bookshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mirea.bookshop.entities.User;
import ru.mirea.bookshop.services.interfaces.UserService;

@Controller
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
            @ModelAttribute("user_form") User user, BindingResult bindingResult, Model model
            ) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "registration";
        }
        if (!userService.add(user)) {
            model.addAttribute("message", "Ползователь с таким логином уже существует!");
            return "registration";
        }
        model.addAttribute("message", "Успешная регистрация!");
        return "login";
    }
    /*
    кароче, а не смогжет ли какой-то пользователь удалить другого?
    надо подумать и мб нормально сделать
     */
//    @PostMapping("/delete_user/{id}")
//    public String deleteUser(@PathVariable(name = "id") Long id, Model model) {
//        userService.remove(id);
//        return "login";
//    }
}
