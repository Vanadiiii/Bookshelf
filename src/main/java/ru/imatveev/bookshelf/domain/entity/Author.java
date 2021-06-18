package ru.imatveev.bookshelf.domain.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table
@RequiredArgsConstructor
public class Author {
    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @Column(name = "full_name", nullable = false, unique = true)
    private String fullName;

    @ToString.Exclude
    @JoinTable(name = "author_book_ref",
            joinColumns = @JoinColumn(name = "book_fk"),
            inverseJoinColumns = @JoinColumn(name = "author_fk"))
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    private void addBooks(List<Book> books) {
        this.books.addAll(books);
        books.forEach(book -> book.setAuthor(this));
    }

    private void addBook(Book book) {
        this.books.add(book);
        book.setAuthor(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Author author = (Author) o;

        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
