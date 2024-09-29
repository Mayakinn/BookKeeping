package com.example.books.Repository;

import com.example.books.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    /**
     * SQL query for filtering books easily
     * @param title Books title
     * @param author Books author
     * @param year Books year
     * @param rating Books rating
     * @return Filtered list
     */
    @Query("SELECT b FROM Book b WHERE " +
            "(:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:author IS NULL OR LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%'))) AND " +
            "(:year IS NULL OR b.Year = :year) AND " +
            "(:rating IS NULL OR b.Rating = :rating)")
    List<Book> findByFilters(@Param("title") String title,
                             @Param("author") String author,
                             @Param("year") Integer year,
                             @Param("rating") Integer rating);
}
