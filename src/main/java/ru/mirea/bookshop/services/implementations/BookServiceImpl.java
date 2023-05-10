package ru.mirea.bookshop.services.implementations;

import org.springframework.stereotype.Service;
import ru.mirea.bookshop.entities.Book;
import ru.mirea.bookshop.repos.BookRepository;
import ru.mirea.bookshop.services.interfaces.BookService;

import java.util.List;
import java.util.Optional;

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
    public List<Book> search(String searchPrompt) {
        return bookRepository.findAll().stream()
                .filter(book ->
                        (book.getName().toLowerCase() + " " + book.getAuthor().toLowerCase()).contains(searchPrompt))
                .toList();
    }
}
