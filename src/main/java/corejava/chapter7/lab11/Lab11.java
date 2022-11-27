package corejava.chapter7.lab11;

import java.util.*;
import java.util.stream.Collectors;

public class Lab11 {

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
        Random random = createCustomRandom(words.size() - 1, 1, words.size() - 1);
        Collections.shuffle(words, random);
    }

    private static Random createCustomRandom(int firstNumber, int origin, int bound) {
        return new Random() {
            boolean isFirst = true;

            @Override
            public int nextInt(int bound) {
                if (isFirst) {
                    isFirst = false;
                    return firstNumber;
                }
                return super.nextInt(origin, bound);
            }
        };
    }
}
