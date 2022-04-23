package corejava.chapter3.additional.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>() {{
            add("1");
            add("22");
            add("333");
            add("4444");
            add("55555");
            add("666666");
            add("7777777");
        }};

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        MappingIterator<String> mIterString = MappingIterator.fromIterator(strings.iterator());
        while (mIterString.hasNext()) {
            System.out.println(mIterString.next());
        }

        MappingIterator<Integer> mIterInteger = MappingIterator
                .fromIterator(strings.iterator())
                .map(String::length);

        while (mIterInteger.hasNext()) {
            System.out.println(mIterInteger.next());
        }

        MappingIterator<Integer> mIterOneMoreInteger = MappingIterator
                .fromIterator(strings.iterator())
                .map(String::length)
                .map(number -> number * 10);

        while (mIterOneMoreInteger.hasNext()) {
            System.out.println(mIterOneMoreInteger.next());
        }
    }
}
