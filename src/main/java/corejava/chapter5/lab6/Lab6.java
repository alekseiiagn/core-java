package corejava.chapter5.lab6;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lab6 {

    private static final String FILE_PATH_TO_CORRECTED_DATA = "src/main/resources/chapter5/lab1/correctedData.txt";

    public static void main(String[] args) {
        firstVarious(FILE_PATH_TO_CORRECTED_DATA);
        secondVarious(FILE_PATH_TO_CORRECTED_DATA);
        thirdVarious(FILE_PATH_TO_CORRECTED_DATA);
    }

    public static void firstVarious(String filepath) {
        Exception mainEx = null;
        BufferedReader in = null;
        try {
            in = createBufferReaderForFilepath(filepath);
            //тут чтение
        } catch (IOException ex) {
            mainEx = ex;
        } finally {
            close(mainEx, in);
        }
    }

    private static BufferedReader createBufferReaderForFilepath(String filepath) throws IOException {
        return Files.newBufferedReader(Path.of(filepath), StandardCharsets.UTF_8);
    }

    private static void close(Exception mainEx, BufferedReader in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                if (mainEx != null) {
                    mainEx.addSuppressed(e);
                } else {
                    mainEx = e;
                }
            }
        }
        if (mainEx != null) {
            throw new RuntimeException(mainEx);
        }
    }

    public static void secondVarious(String filepath) {
        BufferedReader in = null;
        try {
            try {
                in = createBufferReaderForFilepath(filepath);
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
        try (BufferedReader in = createBufferReaderForFilepath(filepath)) {
            //тут чтение
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }
}
