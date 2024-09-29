package com.example.books;

import com.example.books.Model.Book;
import com.example.books.Service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        bookService.saveBook(new Book("Sample Book", "Sample Author", 1234, 3, 2020));
        bookService.saveBook(new Book("Random Ahhh book", "Random Ahhhh author ", 4206, 5, 1949));

    }

    @Test
    public void testGetBooksByTitleFilter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                        .param("query", "Sample Book")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].title").value("Sample Book"));
    }

    @Test
    public void testUpdateBookRating() throws Exception {
        int isbn = 1234;

        mockMvc.perform(MockMvcRequestBuilders.put("/books/" + isbn + "/rating")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"rating\": 5}"))
                .andExpect(status().isOk());

        Optional<Book> updatedBook = bookService.getBook(isbn);
        assert updatedBook.isPresent();
        assert updatedBook.get().getRating() == 5;
    }
}
