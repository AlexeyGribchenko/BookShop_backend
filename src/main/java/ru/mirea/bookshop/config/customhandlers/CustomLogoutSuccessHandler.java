package ru.mirea.bookshop.config.customhandlers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import ru.mirea.bookshop.entities.User;
import ru.mirea.bookshop.services.interfaces.UserService;

import java.io.IOException;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    private final UserService userService;

    public CustomLogoutSuccessHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onLogoutSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException
    {
        User user = (User) authentication.getPrincipal();
        String username = user.getUsername();
        System.out.println("The user " + username + " has logged out.");

        response.sendRedirect(request.getContextPath());
    }
}
