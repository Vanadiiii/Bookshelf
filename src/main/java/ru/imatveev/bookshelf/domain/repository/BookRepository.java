package ru.imatveev.bookshelf.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.imatveev.bookshelf.domain.entity.Book;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findAllByTitleContainsAndAuthor_FullNameContains(String title, String authorName);
}
