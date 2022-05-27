package corejava.chapter4.lab9;

import corejava.chapter2.lab16_17.Queue;
import corejava.chapter4.lab1_2_3.Point;
import corejava.chapter4.lab4_5.shape.Circle;
import corejava.chapter4.lab4_5.shape.Shape;

import java.lang.reflect.Field;
import java.util.*;

public class Lab9 {

    private static final Set<Class<?>> BOX_TYPES;

    static {
        BOX_TYPES = new HashSet<>();
        BOX_TYPES.add(Boolean.class);
        BOX_TYPES.add(Character.class);
        BOX_TYPES.add(Byte.class);
        BOX_TYPES.add(Short.class);
        BOX_TYPES.add(Integer.class);
        BOX_TYPES.add(Long.class);
        BOX_TYPES.add(Float.class);
        BOX_TYPES.add(Double.class);
        BOX_TYPES.add(Void.class);
    }

    public static boolean isBoxType(Class<?> clazz) {
        return BOX_TYPES.contains(clazz);
    }

    static final Point staticPoint = new Point(0, 0);

    public static void main(String[] args) {

        Point point = new Point(0, 0);

        Shape circle = new Circle(new Point(0, 0), 20);

        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        Queue.Iterator iterator = queue.iterator();

        Integer a = 0;

        Character[] strings = {'1', '2', '3'};

        Object[] objects = {
                strings,
                0,
                a,
                point,
                queue,
                iterator,
                circle,
                staticPoint
        };

        for (Object obj : objects) {
            System.out.println(toString(obj));
        }
    }


    public static String toString(Object object) {

        StringBuilder sb = new StringBuilder();
        String className = object.getClass().getSimpleName();

        if (isBoxType(object.getClass())) {
            if (object.getClass().isArray()) {
                sb.append(Arrays.toString((Object[]) object));
            } else {
                sb.append(object);
            }
        } else {
            try {
                for (Field f : object.getClass().getDeclaredFields()) {
                    if (sb.length() > className.length() + 3) {
                        sb.append(", ");
                    }

                    Object value = null;
                    if (f.trySetAccessible()) {
                        f.setAccessible(true);
                        value = f.get(object);
                    }
                    sb.append(f.getType().getSimpleName()).append(' ').append(f.getName()).append('=').append(value);
                }
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }

        return sb.append('}').toString();
    }
}
