package ru.mirea.bookshop.services.interfaces;

import ru.mirea.bookshop.entities.Book;

import java.util.List;

public interface BookService {
    void add(Book book);
    void remove(Long id);
    List<Book> getAll();

    Book getBook(Long id);
    List<Book> search(String searchPrompt);
}
