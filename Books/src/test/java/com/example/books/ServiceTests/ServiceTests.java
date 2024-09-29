package com.example.books.Service;

import com.example.books.Model.Book;
import com.example.books.Repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        book1 = new Book("Test Title1", "Test Author", 123456, 4, 2023);
        book2 = new Book("Test Title2", "Test Author", 123456, 4, 2023);
        book3 = new Book("Test Title3", "Test Author", 123456, 4, 2023);
        book4 = new Book("Test Title4", "Test Author", 123456, 4, 2023);
        book = new Book("Test Title", "Test Author", 123456, 4, 2023);

    }

    @Test
    void testGetBook() {
        when(bookRepository.findById(book.getIsbn())).thenReturn(Optional.of(book));

        Optional<Book> result = bookService.getBook(book.getIsbn());
        assertTrue(result.isPresent());
        assertEquals(book.getIsbn(), result.get().getIsbn());
    }

    @Test
    void testSaveBook() {
        bookService.saveBook(book);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testDeleteBook() {
        bookService.deleteBook(book.getIsbn());
        verify(bookRepository, times(1)).deleteById(book.getIsbn());
    }

    @Test
    void testSearchBooks() {
        bookService.findByFilters("Test Title", "Test Author", 2023, 4);
        verify(bookRepository, times(1)).findByFilters("Test Title", "Test Author", 2023, 4);
    }
}
