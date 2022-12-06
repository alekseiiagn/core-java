package corejava.chapter7.lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Lab8Var2 {

    public static void main(String[] args) {
        try {
            String[] lines = readLinesFromFile("src/main/resources/chapter7/lab7/text8.txt");
            Map<String, List<Integer>> linesForWords = getLinesWords(lines);
            System.out.println(linesForWords);
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

    private static Map<String, List<Integer>> getLinesWords(String[] lines) {
        Map<String, List<Integer>> linesForWords = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            String[] words = lines[i].split(" ");
            for (String word : words) {
                linesForWords.computeIfAbsent(word, newList -> new ArrayList<>())
                        .add(i + 1);
            }
        }
        return linesForWords;
    }
}


