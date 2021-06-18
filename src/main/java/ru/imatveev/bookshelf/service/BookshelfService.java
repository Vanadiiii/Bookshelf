package ru.imatveev.bookshelf.service;

import ru.imatveev.bookshelf.domain.entity.Author;
import ru.imatveev.bookshelf.domain.entity.Book;

import java.util.List;
import java.util.UUID;

public interface BookshelfService {
    List<Book> findByParams(String title, String authorName);

    UUID saveAuthor(Author author);

    UUID saveBook(Book book);
}
