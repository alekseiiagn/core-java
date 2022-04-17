package corejava.chapter3.lab10;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Path;
import java.util.Arrays;

public class Lab10 {
    public static void main(String[] args) {
        Path path = Path.of("/Users/aleksejagnenkov/IdeaProjects/CoreJava/src/main/java/corejava/chapter3");
        System.out.println(Arrays.toString(takeAllSubdirectoriesByPath(path)));
        System.out.println(Arrays.toString(takeAllSubdirectoriesByPathWithLambda(path)));
        System.out.println(Arrays.toString(takeAllSubdirectoriesByPathWithAnon(path)));
    }

    private static File[] takeAllSubdirectoriesByPath(Path path) {
        File file = path.toFile();
        if (file.isDirectory())
            return file.listFiles(File::isDirectory);
        return null;
    }

    private static File[] takeAllSubdirectoriesByPathWithLambda(Path path) {
        File file = path.toFile();
        if (file.isDirectory())
            return file.listFiles(s -> s.isDirectory());
        return null;
    }

    private static File[] takeAllSubdirectoriesByPathWithAnon(Path path) {
        File file = path.toFile();
        return file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
    }
}
