package corejava.chapter5.lab5;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get("src/main/resources/chapter5/lab1/correctedData.txt"));
            out = new PrintWriter("src/main/resources/chapter5/lab5/outputData.txt");
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
