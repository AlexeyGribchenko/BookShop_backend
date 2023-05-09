package ru.mirea.bookshop.services.implementations;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mirea.bookshop.entities.User;
import ru.mirea.bookshop.entities.enums.Role;
import ru.mirea.bookshop.repos.UserRepository;
import ru.mirea.bookshop.services.interfaces.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean add(User user) {
        if(userRepository.findByUsername(user.getUsername()) != null) {
            return false;
        }
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        userRepository.save(user);
        return true;
    }

    @Override
    public void remove(Long id) throws IllegalArgumentException{
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("User (" + id + ") not found!");
        }
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User (" + username + ") not found!");
        }

        return user;
    }

    @Override
    public void changeActivity(Long id) throws IllegalArgumentException {
        Optional<User> optUser = userRepository.findById(id);
        if (optUser.isPresent()) {
            User user = optUser.get();
            user.setActive(!user.isActive());
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User (" + id + ") not found!");
        }
    }

    @Override
    public void changePermissions(Long id) throws IllegalArgumentException {
        Optional<User> optUser = userRepository.findById(id);
        if (optUser.isPresent()) {
            User user = optUser.get();
            if (user.getRoles().contains(Role.ROLE_ADMIN)) {
                user.getRoles().remove(Role.ROLE_ADMIN);
            } else {
                user.getRoles().add(Role.ROLE_ADMIN);
            }
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User (" + id + ") not found!");
        }
    }

    @Override
    public void updateProfilePicture(Long id, String pictureName) throws IllegalArgumentException {
        Optional<User> optUser = userRepository.findById(id);
        if (optUser.isPresent()) {
            User user = optUser.get();
            user.setProfilePictureName(Objects.requireNonNullElse(pictureName, "default_profile_image.jpg"));
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User (" + id + ") not found!");
        }
    }
}
