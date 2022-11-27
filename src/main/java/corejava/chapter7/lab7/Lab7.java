package corejava.chapter7.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Lab7 {
    public static void main(String[] args) {
        try {
            String text = readTextFromFile("src/main/resources/chapter7/lab7/text7.txt");
            Map<String, Integer> wordCounts = countWords(text);
            System.out.println(wordCounts);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readTextFromFile(String filepath) throws FileNotFoundException {
        StringBuilder text = new StringBuilder();
        Scanner scanner = new Scanner(new File(filepath));
        while (scanner.hasNext()) {
            text.append(scanner.nextLine());
        }
        return text.toString();
    }

    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCounts = new TreeMap<>();
        Scanner scanner = new Scanner(text);
        while (scanner.hasNext()) {
            String word = scanner.next();
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        return wordCounts;
    }
}