package corejava.chapter6;

public class Exceptions {
    @SuppressWarnings("unchecked")
    public static <T extends Throwable> void throwAs(Throwable ex) throws T {
        throw (T) ex;
    }
}