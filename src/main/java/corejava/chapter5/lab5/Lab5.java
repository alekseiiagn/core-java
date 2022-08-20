package corejava.chapter5.lab5;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Lab5 {

    private static final String FILE_PATH_TO_OUTPUT_DATE = "src/main/resources/chapter5/lab5/outputData.txt";
    private static final String FILE_PATH_TO_CORRECTED_DATA = "src/main/resources/chapter5/lab1/correctedData.txt";


    public static void main(String[] args) {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get(FILE_PATH_TO_CORRECTED_DATA));
            out = new PrintWriter(FILE_PATH_TO_OUTPUT_DATE);
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(in);
            close(out);
        }
    }

    private static void close(Closeable out) {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
