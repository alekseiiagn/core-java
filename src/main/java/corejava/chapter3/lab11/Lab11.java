package corejava.chapter3.lab11;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

public class Lab11 {

    private static String[] takeAllFilesByPath(Path path) {
        File file = path.toFile();
        return file.list();
    }

    private static String[] takeAllFilesByPathWithLambda(Path path, String extension) {
        File file = path.toFile();
        return file.list((s, b) -> b.contains(".") && b.split("\\.")[1].equals(extension));
    }

    public static void main(String[] args) {
        Path path = Path.of("/Users/aleksejagnenkov/IdeaProjects/CoreJava/src/main/java/corejava/chapter3/lab6");
        System.out.println(Arrays.toString(takeAllFilesByPath(path)));
        System.out.println(Arrays.toString(takeAllFilesByPathWithLambda(path, "java")));
    }
}
