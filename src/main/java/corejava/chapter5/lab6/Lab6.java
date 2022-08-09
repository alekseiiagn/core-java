package corejava.chapter5.lab6;

import corejava.chapter5.lab1_2_3.Lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lab6 {
    public static void main(String[] args) {
        firstVarious(Lab1.FILE_PATH);
        secondVarious(Lab1.FILE_PATH);
        thirdVarious(Lab1.FILE_PATH);
    }

    public static void firstVarious(String filepath) {
        BufferedReader in = null;
        try {
            in = Files.newBufferedReader(Path.of(filepath), StandardCharsets.UTF_8);
            //тут чтение
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void secondVarious(String filepath) {
        BufferedReader in = null;
        try {
            try {
                in = Files.newBufferedReader(Path.of(filepath), StandardCharsets.UTF_8);
                //тут чтение
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }

    public static void thirdVarious(String filepath) {
        try (BufferedReader in = Files.newBufferedReader(Path.of(filepath), StandardCharsets.UTF_8)) {
            //тут чтение
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }
}
