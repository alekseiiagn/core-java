package corejava.chapter7.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Lab2 {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("hello");
        strings.add("world!");
        strings.add("i");
        strings.add("am");
        strings.add("here");

        toUpperCaseStringsIndex(strings);
        //toUpperCaseStringsIterator(strings);
        //toUpperCaseStringsReplaceAll(strings);

        System.out.println(strings);
    }

    public static void toUpperCaseStringsIterator(List<String> strings){
        ListIterator<String> li = strings.listIterator();
        while (li.hasNext()) {
            li.set((li.next()).toUpperCase());
        }
    }

    public static void toUpperCaseStringsIndex(List<String> strings){
        for (int i = 0; i < strings.size(); i++) {
            strings.set(i, strings.get(i).toUpperCase());
        }
    }

    public static void toUpperCaseStringsReplaceAll(List<String> strings){
        strings.replaceAll(String::toUpperCase);
    }
}
