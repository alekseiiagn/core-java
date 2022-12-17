package corejava.chapter7.additional.entities;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private String name;
    private String author;
    private Genre genre;

    public Book() {}

    public Book(String name, String author, Genre genre) {
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Book setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(name, book.name)
                && Objects.equals(author, book.author)
                && genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, genre);
    }

    @Override
    public int compareTo(Book o) {
        return this.getName().compareTo(o.getName());
    }
}
