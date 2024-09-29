package com.example.books.Service;

import com.example.books.Model.Book;
import com.example.books.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    /**
     * constructor-based dependency injector
     * @param bookRepository Repository
     */
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Gets all the books list
     * @return Returns list
     */
    public List<Book> getBooksList() {
        return bookRepository.findAll();
    }

    /**
     * Find by ID method
     * @param isbn Books ID
     * @return Book with matching ISBN
     */
    public Optional<Book> getBook(int isbn) {
        return bookRepository.findById(isbn);
    }

    /**
     * Saves book
     * @param book Book object
     */
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    /**
     * Deletes book
     * @param isbn Books ID
     */
    public void deleteBook(int isbn) {
        bookRepository.deleteById(isbn);
    }

    /**
     * Filtering method
     * @param title Books title
     * @param author Books author
     * @param year Books year
     * @param rating Books rating
     * @return returns the filtered list
     */
    public List<Book> findByFilters(String title, String author, Integer year, Integer rating) {
        if (title == null && author == null && year == null && rating == null) {
            return bookRepository.findAll();
        }
        return bookRepository.findByFilters(title, author, year, rating);
    }

    /**
     * Updates the books ratings
     * @param isbn Books ID
     * @param newRating Books new rating
     */
    public void updateBookRating(int isbn, int newRating) {
        Optional<Book> bookOptional = bookRepository.findById(isbn);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setRating(newRating);
            bookRepository.save(book);
        } else {
            throw new RuntimeException("Book with ISBN " + isbn + " not found.");
        }
    }

}
