package corejava.chapter4.lab11;

import java.lang.reflect.Field;

public class Lab11 {
    public static void main(String[] args){
        try {
            Field field = Class.forName("java.lang.System").getDeclaredField("out");
            field.getType().getMethod("println", String.class).invoke(field.get(null), "Hello, World");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
