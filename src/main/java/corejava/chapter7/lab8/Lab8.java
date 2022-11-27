package corejava.chapter7.lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Lab8 {

    public static void main(String[] args) {
        try {
            String[] lines = readLinesFromFile("src/main/resources/chapter7/lab7/text8.txt");
            Set<String> words = getWords(lines);
            String[] lineWithWords = getLinesWithWords(lines, words);
            System.out.println(Arrays.toString(lineWithWords));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] readLinesFromFile(String filepath) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filepath));
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        return lines.toArray(new String[0]);
    }

    public static Set<String> getWords(String[] lines) {
        return Arrays.stream(lines)
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .collect(Collectors.toSet());
    }

    public static String[] getLinesWithWords(String[] lines, Set<String> words) {
        return Arrays.stream(lines)
                .filter(line -> isContainsAll(line, words))
                .toList()
                .toArray(new String[0]);
    }

    private static boolean isContainsAll(String line, Set<String> words) {
        return Arrays.stream(line.split("\\s++"))
                .collect(Collectors.toSet())
                .containsAll(words);
    }
}


