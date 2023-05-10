package ru.mirea.bookshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_order")
public class Order {

    @Id
    @SequenceGenerator(name = "t_order_seq", allocationSize = 1)
    @GeneratedValue(generator = "t_order_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total_price")
    private Integer totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToMany(cascade = { CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "t_order_books",
        joinColumns = { @JoinColumn(name = "order_id", referencedColumnName = "id",
                nullable = false, updatable = false) },
        inverseJoinColumns = { @JoinColumn(name = "book_id", referencedColumnName = "id",
                nullable = false, updatable = false)})
    private List<Book> bookList;

    public Order(User user, List<Book> books) {
        this.orderDate = new Date();
        this.user = user;
        Optional<Integer> totalPrice = books
                .stream()
                .map((Book::getPrice))
                .reduce(Integer::sum);
        this.totalPrice = totalPrice.orElse(0);
        this.bookList = List.copyOf(books);
    }

    @Override
    public String toString() {
        return String.format("Order(%d)", id);
    }
}
