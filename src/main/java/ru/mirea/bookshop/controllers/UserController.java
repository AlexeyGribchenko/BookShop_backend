package ru.mirea.bookshop.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.mirea.bookshop.entities.User;
import ru.mirea.bookshop.services.interfaces.UserService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAnyAuthority('ROLE_USER')")
public class UserController {

    @Value("${upload.path}")
    private String uploadPath;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    public String showAll(Model model) {
        model.addAttribute("userList", userService.getAll());
        return "users_admin";
    }

    @PostMapping("/change_activity/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    public String deactivateUserById(@PathVariable(name = "id") Long id, Model model) {
        userService.changeActivity(id);
        model.addAttribute("userList", userService.getAll());
        return "users_admin";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    public String deleteUserById(@PathVariable(name = "id") Long id, Model model) {
        userService.remove(id);
        model.addAttribute("userList", userService.getAll());
        return "users_admin";
    }

    @PostMapping("/change_permissions/{id}")
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    public String changePermissions(@PathVariable(name = "id") Long id, Model model) {
        userService.changePermissions(id);
        model.addAttribute("userList", userService.getAll());
        return "users_admin";
    }

    @PostMapping("/update_profile_picture/{id}")
    public String updateProfilePicture(
            @AuthenticationPrincipal User user,
            @PathVariable(name = "id") Long id,
            @RequestParam(name = "profilePicture") MultipartFile file,
            Model model) throws IOException {
        if (!file.isEmpty()) {
            File uploadDir = new File(uploadPath + "/static/img/profile_pictures");

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            File userCurrentProfilePicture =
                    new File(uploadPath + "/static/img/profile_pictures/" + user.getProfilePictureName());
            userCurrentProfilePicture.deleteOnExit();

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/static/img/profile_pictures/" + resultFileName));

            user.setProfilePictureName(resultFileName);
        } else {
            user.setProfilePictureName("default_profile_img.png");
        }
        userService.update(user);
        model.addAttribute("user", user);
        return "profile";
    }
}
