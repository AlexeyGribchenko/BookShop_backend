package ru.mirea.bookshop.services.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.mirea.bookshop.entities.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    boolean add(User user);
    void remove(Long id);
    List<User> getAll();

    void update(User user);
}
