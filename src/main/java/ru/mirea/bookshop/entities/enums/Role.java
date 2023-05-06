package ru.mirea.bookshop.entities.enums;

import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

@Table(name = "usr_role")
public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
