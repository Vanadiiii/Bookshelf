package ru.imatveev.bookshelf.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.imatveev.bookshelf.domain.entity.Author;

import java.util.Optional;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
    Optional<Author> findAuthorByFullName(String fullName);
}
