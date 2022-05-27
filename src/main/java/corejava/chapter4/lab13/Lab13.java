package corejava.chapter4.lab13;

import java.lang.reflect.Method;

public class Lab13 {
    public static void main(String[] args) {
        try {
            print(Math.class.getMethod("sqrt", double.class), 9, 16, 1);
            print(Double.class.getMethod("toHexString", double.class), 9, 16, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void print(Method m, double lowerLimit, double upperLimit, double step) throws Exception {
        System.out.println(m.getDeclaringClass().getSimpleName() + "." + m.getName() + "(double obj)");
        for (double i = lowerLimit; i <= upperLimit; i += step) {
            System.out.println(i + " -> " + m.invoke(null, i));
        }
    }
}
