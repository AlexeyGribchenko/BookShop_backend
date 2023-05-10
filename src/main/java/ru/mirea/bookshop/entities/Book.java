package ru.mirea.bookshop.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_book")
public class Book {

    @Id
    @Nonnull
    @SequenceGenerator(name = "t_product_seq", allocationSize = 1)
    @GeneratedValue(generator = "t_product_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 2048)
    private String description;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private Integer price;

    @Column(name = "img_name")
    private String imgName;
}
