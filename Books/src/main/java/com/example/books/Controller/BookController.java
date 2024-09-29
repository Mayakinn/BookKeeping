package com.example.books.Controller;

import com.example.books.Model.Book;
import com.example.books.Service.BookService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    private final HttpServletResponse httpServletResponse;
    private final BookService bookService;

    /**
     * Dependency injection constructor
     * @param bookService
     * @param httpServletResponse
     */
    @Autowired
    public BookController(BookService bookService, HttpServletResponse httpServletResponse) {
        this.bookService = bookService;
        this.httpServletResponse = httpServletResponse;
    }

    /**
     * Getting book method
     * @param isbn books ID number
     * @return Returns book
     */
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable int isbn) {
        Optional<Book> book = bookService.getBook(isbn);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Book adding method
     * @param book
     */
    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    /**
     * Book filtering method
     * @param title Books title
     * @param author Books author
     * @param year Books year
     * @param rating Books rating
     * @param model Books model
     * @return list of filtered books
     */
    @GetMapping("/books")
    public String getBooks(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "author", required = false) String author,
            @RequestParam(value = "year", required = false) Integer year,
            @RequestParam(value = "rating", required = false) Integer rating,
            Model model) {

        List<Book> booksList = bookService.findByFilters(title, author, year, rating);

        model.addAttribute("books", booksList);
        model.addAttribute("title", title);
        model.addAttribute("author", author);
        model.addAttribute("year", year);
        model.addAttribute("rating", rating);

        return "books";
    }

    /**
     * Interchangable rating method
     * @param isbn Books ID
     * @param rating Books rating
     * @return Redirects back to books list after changing the rating
     */
    @PostMapping("/books/{isbn}/rating")
    public String updateRating(@PathVariable("isbn") int isbn, @RequestParam("rating") int rating) {
        bookService.updateBookRating(isbn, rating);
        return "redirect:/books";
    }


}
