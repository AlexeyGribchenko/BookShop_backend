package ru.mirea.bookshop.services.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.mirea.bookshop.entities.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    boolean add(User user);
    void remove(Long id)  throws IllegalArgumentException;
    List<User> getAll();
    void update(User user);
    void changeActivity(Long id) throws IllegalArgumentException;
    void changePermissions(Long id) throws IllegalArgumentException;
    void updateProfilePicture(Long id, String pictureName) throws IllegalArgumentException;
}
