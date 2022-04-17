package corejava.chapter2.lab13;
import liquibase.util.csv.CSVReader;

import java.io.FileReader;

public class Lab13 {
    private static final String PATH = "src/main/resources/numbers.csv";

    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(PATH));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            for (String e : nextLine) {
                System.out.format("%s ", e);
            }
        }
    }
}
