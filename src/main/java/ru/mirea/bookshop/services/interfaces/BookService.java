package ru.mirea.bookshop.services.interfaces;

import ru.mirea.bookshop.entities.Book;
import ru.mirea.bookshop.entities.enums.Genre;

import java.util.List;
import java.util.Set;

public interface BookService {
    void add(Book book);
    void remove(Long id);
    List<Book> getAll();

    Book getBook(Long id);
    List<Book> filterByGenre(Set<Genre> genres);
    List<Book> filterByName(String name);
    List<Book> filterByAuthor(String author);
}
