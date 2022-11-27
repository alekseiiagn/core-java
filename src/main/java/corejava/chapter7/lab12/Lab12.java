package corejava.chapter7.lab12;

import java.util.*;
import java.util.stream.Collectors;

public class Lab12 {

    public static void main(String[] args) {
        List<String> words = readWordsFromTerminal();
        customShuffle(words);
        System.out.println(words);
    }

    private static List<String> readWordsFromTerminal() {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        return Arrays.stream(sentence.split("\\s+")).collect(Collectors.toList());
    }

    private static void customShuffle(List<String> words) {
        Collections.shuffle(words);
        toCorrectFirstWord(words);
        toCorrectDot(words);
    }

    private static void toCorrectFirstWord(List<String> words) {
        words.set(0, toUppercaseFirstChar(words.get(0)));
        for (int i = 1; i < words.size(); i++) {
            String curr = words.get(i);
            if (Character.isUpperCase(curr.charAt(0))) {
                words.set(i, toLowerCaseFirstChar(curr));
            }
        }
    }

    private static String toUppercaseFirstChar(String word) {
        char firstCharacter = word.charAt(0);
        return Character.toUpperCase(firstCharacter) + word.substring(1);
    }

    private static String toLowerCaseFirstChar(String word) {
        char first = word.charAt(0);
        return Character.toLowerCase(first) + word.substring(1);
    }

    private static void toCorrectDot(List<String> words) {
        int size = words.size();
        for (int i = 0; i < size; i++) {
            String curr = words.get(i);
            if (curr.contains(".")) {
                words.set(i, curr.substring(0, curr.length()-1));
            }
        }
        words.set(size - 1, words.get(size - 1) + ".");
    }
}
