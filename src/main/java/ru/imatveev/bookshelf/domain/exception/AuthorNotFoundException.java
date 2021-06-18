package ru.imatveev.bookshelf.domain.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String message) {
        super(message);
    }

    public static AuthorNotFoundException ofName(String fullName) {
        return new AuthorNotFoundException("Author with name '" + fullName + "' wasn't found");
    }

    public static AuthorNotFoundException empty() {
        return new AuthorNotFoundException("There are no authors without name");
    }
}
