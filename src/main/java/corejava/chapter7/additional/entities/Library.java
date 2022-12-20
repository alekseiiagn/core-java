package corejava.chapter7.additional.entities;

import java.util.*;

public class Library {
    private final Map<String, Book> bookcase;
    private final Map<String, Integer> countsByAuthor;

    public Library() {
        bookcase = new HashMap<>();
        countsByAuthor = new HashMap<>();
    }

    public void add(Book book) {
        bookcase.put(book.getName(), book);
        countsByAuthor.put(book.getAuthor(), getCountBooks(book.getAuthor()) + 1);
    }

    public Book take(String bookName) {
        Book book = bookcase.remove(bookName);
        countsByAuthor.compute(book.getAuthor(), (author, count) -> count - 1 == 0 ? null : count - 1);
        return book;
    }

    private int getCountBooks(String author) {
        return countsByAuthor.getOrDefault(author, 0);
    }

    public Set<String> authors() {
        return countsByAuthor.keySet();
    }

    public Iterator<Book> sorted(Comparator<Book> comparator) {
        return bookcase.values()
                .stream()
                .sorted(comparator)
                .iterator();
    }
}
