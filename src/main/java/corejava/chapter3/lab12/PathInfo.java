package corejava.chapter3.lab12;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

public class PathInfo {
    public static void printPathInfo(Path pathname) {
        File[] files = pathname.toFile().listFiles();
        if (files != null) {
            Comparator<File> comp = Comparator.comparing((File s) -> !s.isDirectory()).thenComparing(File::getName);
            Arrays.sort(files, comp);
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
}
