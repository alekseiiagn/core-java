package corejava.chapter7.additional;

import corejava.chapter7.additional.entities.Book;
import corejava.chapter7.additional.entities.Genre;
import corejava.chapter7.additional.entities.Library;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class Main {

    static Random random = new Random();

    public static void main(String[] args) {
        Library library = new Library();
        library.add(new Book("1", "11", Genre.ACTION));
        System.out.println(library);
        library.take("1");
        System.out.println(library.authors());

        Library library1 = createRandomLibrary(random.nextInt(10));
        System.out.println("SORT-1");
        sortAndPrint(library1, Comparator.comparing(Book::getName));
        System.out.println("SORT-2");
        sortAndPrint(library1, Comparator.comparing(Book::getAuthor));
        System.out.println("SORT-3");
        sortAndPrint(library1, Comparator.comparing(Book::getGenre));
    }

    private static Library createRandomLibrary(int size) {
        Library library = new Library();
        for (int i = 0; i < size; i++) {
            library.add(createRandomBook());
        }
        return library;
    }

    public static Book createRandomBook() {
        return new Book()
                .setName(random.nextInt(256) + "")
                .setAuthor(""
                        + random.nextInt(256) + " "
                        + random.nextInt(256) + " "
                        + random.nextInt(256))
                .setGenre(Genre.values()[random.nextInt(Genre.values().length - 1)]);
    }

    private static void sortAndPrint(Library library, Comparator<Book> comparator) {
        Iterator<Book> iter = library.sorted(comparator);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}