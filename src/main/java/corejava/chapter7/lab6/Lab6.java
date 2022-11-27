package corejava.chapter7.lab6;

import java.util.*;

public class Lab6 {

    public static void main(String[] args) {

        //first
        Map<String, Set<String>> hashMapSet = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMapSet.put(i + "hash->", new HashSet<>());
        }

        //second
        Map<String, Set<String>> treeMapHashSet = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            treeMapHashSet.put(i + "hash->", new HashSet<>());
        }

        //third
        Map<String, Set<String>> treeMapSet = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            treeMapSet.put(i + "tree->", new TreeSet<>());
        }

        foo(hashMapSet);
        foo(treeMapHashSet);
        foo(treeMapSet);

        //Для документа можно воспользоваться Properties
        Properties properties = new Properties();

    }

    static void foo(Map<String, Set<String>> map) {
        System.out.println(map);
    }
}