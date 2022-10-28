package corejava.chapter6.lab14;

import java.util.List;

public class Lab14 {

    public static void main(String[] args) {

    }

    public static <T extends AutoCloseable> void closeAll(List<T> elems) throws Exception {
        Exception exception = new Exception("One or more elems not closed!");
        for (T elem : elems) {
            try {
                elem.close();
            } catch (Exception ex) {
                exception.addSuppressed(ex);
            }
        }
        throwIsHaveSuppressed(exception);
    }

    private static void throwIsHaveSuppressed(Exception exception) throws Exception {
        if (exception.getSuppressed().length > 0) {
            throw exception;
        }
    }
}
