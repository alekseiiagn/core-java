package corejava.chapter7.lab9;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static corejava.chapter7.lab7.Lab7.readTextFromFile;

public class Lab9 {

    public static void main(String[] args) {
        try {
            String text = readTextFromFile("src/main/resources/chapter7/lab7/text7.txt");
            Map<String, Integer> wordCounts = countWordsWithContains(text);
            System.out.println(wordCounts);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Integer> countWordsWithContains(String text) {
        Map<String, Integer> wordCounts = new TreeMap<>();
        Scanner scanner = new Scanner(text);
        while (scanner.hasNext()) {
            String word = scanner.next();
            //----------------------------
            Integer nextCount = 1;
            if(wordCounts.containsKey(word)){
                Integer count = wordCounts.get(word);
                nextCount += count;
            }
            //----------------------------
            wordCounts.put(word, nextCount);
        }
        return wordCounts;
    }

    public static Map<String, Integer> countWordsWithGet(String text) {
        Map<String, Integer> wordCounts = new TreeMap<>();
        Scanner scanner = new Scanner(text);
        while (scanner.hasNext()) {
            String word = scanner.next();
            //----------------------------
            Integer count = wordCounts.get(word);
            Integer nexValue = (count == null ? 0 : count) + 1;
            //----------------------------
            wordCounts.put(word, nexValue);
        }
        return wordCounts;
    }

    public static Map<String, Integer> countWordsWithGetOrDefault(String text) {
        Map<String, Integer> wordCounts = new TreeMap<>();
        Scanner scanner = new Scanner(text);
        while (scanner.hasNext()) {
            String word = scanner.next();
            //----------------------------
            Integer count = wordCounts.getOrDefault(word, 0);
            Integer nexValue = count + 1;
            //----------------------------
            wordCounts.put(word, nexValue);
        }
        return wordCounts;
    }

    public static Map<String, Integer> countWordsWithPutIfAbsent(String text) {
        Map<String, Integer> wordCounts = new TreeMap<>();
        Scanner scanner = new Scanner(text);
        while (scanner.hasNext()) {
            String word = scanner.next();
            //----------------------------
            Integer count = wordCounts.putIfAbsent(word, 1);
            if (count != null) {
                wordCounts.put(word, count + 1);
            }
            //----------------------------
        }
        return wordCounts;
    }
}
