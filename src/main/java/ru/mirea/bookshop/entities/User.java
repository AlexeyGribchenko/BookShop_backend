package ru.mirea.bookshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.mirea.bookshop.entities.enums.Role;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "t_user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements UserDetails {

    @Id
    @SequenceGenerator(name = "t_user_seq", allocationSize = 1)
    @GeneratedValue(generator = "t_user_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "active")
    private boolean active;

    @Column(name = "profile_picture_name")
    private String profilePictureName;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "t_usr_role", joinColumns = @JoinColumn(name = "usr_id"))
    @Enumerated(EnumType.STRING)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REFRESH})
    private Set<Role> roles;

    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "t_wishlist",
    joinColumns = { @JoinColumn(name = "usr_id", referencedColumnName = "id",
            nullable = false) },
    inverseJoinColumns = { @JoinColumn(name = "book_id", referencedColumnName = "id",
            nullable = false)})
    private List<Book> wishList;

    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "t_cart",
            joinColumns = { @JoinColumn(name = "usr_id", referencedColumnName = "id",
                    nullable = false) },
            inverseJoinColumns = { @JoinColumn(name = "book_id", referencedColumnName = "id",
                    nullable = false)})
    private List<Book> cart;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Order> orders;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public String toString() {
        return String.format("User(%s, %d)", username, id);
    }
}
