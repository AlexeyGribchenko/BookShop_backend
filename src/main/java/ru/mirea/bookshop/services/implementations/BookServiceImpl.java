package ru.mirea.bookshop.services.implementations;

import org.springframework.stereotype.Service;
import ru.mirea.bookshop.entities.Book;
import ru.mirea.bookshop.entities.enums.Genre;
import ru.mirea.bookshop.repos.BookRepository;
import ru.mirea.bookshop.services.interfaces.BookService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        if (bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Book (" + id + ") not found!");
        }
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) throws IllegalArgumentException {
        Optional<Book> optBook = bookRepository.findById(id);
        if (optBook.isPresent()) {
            return optBook.get();
        } else {
            throw new IllegalArgumentException("Book (id = " + id + ") does not exist!");
        }
    }

    @Override
    public List<Book> filterByGenre(Set<Genre> genres) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> book.getGenres().containsAll(genres))
                .toList();
    }



    @Override
    public List<Book> filterByName(String name) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> book
                        .getName().toLowerCase()
                        .contains(name.toLowerCase()))
                .toList();
    }

    @Override
    public List<Book> filterByAuthor(String author) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> book
                        .getAuthor().toLowerCase()
                        .contains(author.toLowerCase()))
                .toList();
    }
}
