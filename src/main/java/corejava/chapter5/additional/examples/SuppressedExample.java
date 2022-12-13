package corejava.chapter5.additional.examples;

import java.io.FileReader;
import java.io.IOException;

public class SuppressedExample {

    public static void main(String[] args) throws Exception {
        readFile("src/main/resources/chapter7/lab7/text7.txt");
    }

    private static void readFile(String filename) throws Exception {
        Exception mainEx = null;
        FileReader reader = null;
        try {
            reader = new FileReader(filename);
            //some logic while throw exception
            throw new RuntimeException();
        } catch (RuntimeException ex) {
            mainEx = ex;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    //допустим, что при close вылетела ошибка
                    throw new IOException();
                } catch (IOException e) {
                    if(mainEx!=null){
                        mainEx.addSuppressed(e);
                    } else {
                        mainEx = e;
                    }
                }
            }
            if(mainEx != null){
                throw mainEx;
            }
        }
    }
}
