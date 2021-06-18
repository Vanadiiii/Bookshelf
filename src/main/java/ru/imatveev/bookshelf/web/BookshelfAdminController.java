package ru.imatveev.bookshelf.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.imatveev.bookshelf.domain.entity.Author;
import ru.imatveev.bookshelf.domain.entity.Book;
import ru.imatveev.bookshelf.service.BookshelfService;

import java.util.List;
import java.util.UUID;

@RequestMapping("bookshelf/admin/v1")
@RequiredArgsConstructor
public class BookshelfAdminController {
    private final BookshelfService bookshelfService;

    @PostMapping("/author")
    public ResponseEntity<UUID> addAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(bookshelfService.saveAuthor(author));
    }

    @PostMapping("/book")
    public ResponseEntity<UUID> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookshelfService.saveBook(book));
    }
}
