package ru.imatveev.bookshelf.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.imatveev.bookshelf.domain.entity.Book;
import ru.imatveev.bookshelf.service.BookshelfService;

import java.util.List;

@RequestMapping("bookshelf/v1")
@RequiredArgsConstructor
public class BookshelfController {
    private final BookshelfService bookshelfService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> findBooksByParams(@RequestParam(required = false, defaultValue = "") String bookName,
                                                        @RequestParam(required = false, defaultValue = "") String authorName) {
        return ResponseEntity.ok(bookshelfService.findByParams(bookName, authorName));
    }
}
