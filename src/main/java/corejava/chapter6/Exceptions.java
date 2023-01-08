package corejava.chapter6;

public class Exceptions {

    @SuppressWarnings("unchecked")
    public static <T extends Throwable> void throwAs(Throwable ex) throws T {
        throw (T) ex;
    }

    public static void throwAs1(Throwable ex) throws RuntimeException {
        throw (RuntimeException) ex;
    }
}