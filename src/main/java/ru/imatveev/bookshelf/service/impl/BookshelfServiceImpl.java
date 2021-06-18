package ru.imatveev.bookshelf.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.imatveev.bookshelf.domain.entity.Author;
import ru.imatveev.bookshelf.domain.entity.Book;
import ru.imatveev.bookshelf.domain.exception.AuthorNotFoundException;
import ru.imatveev.bookshelf.domain.repository.AuthorRepository;
import ru.imatveev.bookshelf.domain.repository.BookRepository;
import ru.imatveev.bookshelf.service.BookshelfService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookshelfServiceImpl implements BookshelfService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public List<Book> findByParams(@NonNull String title, @NonNull String authorName) {
        return bookRepository.findAllByTitleContainsAndAuthor_FullNameContains(title, authorName);
    }

    @Override
    @Transactional
    public UUID saveAuthor(Author author) {
        return authorRepository.save(author)
                .getId();
    }

    @Override
    @Transactional
    public UUID saveBook(@NonNull Book book) {
        Objects.requireNonNull(book.getAuthor());
        String fullName = Optional.ofNullable(book.getAuthor())
                .map(Author::getFullName)
                .orElseThrow(AuthorNotFoundException::empty);
        Optional<Author> authorOp = authorRepository
                .findAuthorByFullName(fullName);

        if (authorOp.isPresent()) {
            book.setAuthor(authorOp.get());
        } else {
            Author savedAuthor = authorRepository.save(book.getAuthor());
            book.setAuthor(savedAuthor);
        }
        return bookRepository.save(book)
                .getId();
    }
}
