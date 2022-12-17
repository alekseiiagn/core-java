package corejava.chapter7.additional.entities;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Library {
    private final Map<String, Book> bookcase;

    public Library() {
        bookcase = new HashMap<>();
    }

    public void add(Book book) {
        bookcase.put(book.getName(), book);
    }

    public Book take(String bookName) {
        return bookcase.remove(bookName);
    }

    public Set<String> authors() {
        return bookcase.values()
                .stream()
                .map(Book::getAuthor)
                .collect(Collectors.toSet());
    }

    public Iterator<Book> sorted(Comparator<Book> comparator) {
        return bookcase.values()
                .stream()
                .sorted(comparator)
                .iterator();
    }
}
