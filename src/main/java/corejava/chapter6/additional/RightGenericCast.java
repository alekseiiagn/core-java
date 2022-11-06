package corejava.chapter6.additional;

public class RightGenericCast {

    public static <T> T cast(Object something, Class<T> cl) {
        return cl.cast(something);
    }
}
