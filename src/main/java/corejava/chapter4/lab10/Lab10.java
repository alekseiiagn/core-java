package corejava.chapter4.lab10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * В int[] нет методов, если что)))
 */

public class Lab10 {

    public static void main(String[] args) {
        Class<?> cl = int[].class;
        while (cl != null) {
            System.out.println("-------------------->" + cl.getTypeName());
            System.out.println("Methods:");
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(Modifier.toString(m.getModifiers())
                        + " " + m.getReturnType().getSimpleName()
                        + " " + m.getName() +Arrays.toString(m.getParameters()).replace('[','(').replace(']',')'));
            }
            cl = cl.getSuperclass();
        }

    }

}
