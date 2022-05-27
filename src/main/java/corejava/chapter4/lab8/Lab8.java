package corejava.chapter4.lab8;

import corejava.chapter2.lab16_17.Queue;
import corejava.chapter4.lab1_2_3.Point;

import java.util.LinkedList;

public class Lab8 {

    public static void main(String[] args) {

        Class<?>[] objects = {
                String[].class,
                new LinkedList<>().getClass(),
                Object.class,
                Queue.Iterator.class,
                int.class,
                new Point(0, 0).getClass(),
                Integer.class
        };


        for (Class<?> obj : objects) {
            System.out.println("--------------> Name: " + obj.getName());
            printInfo(obj);
        }

    }

    private static void printInfo(Class<?> someClass) {
        System.out.println(
                "toString:  " + someClass.toString() + '\n'
                        + "toGenericString:  " + someClass.toGenericString() + '\n'
                        + "descriptorString:  " + someClass.descriptorString() + '\n'
                        + "getCanonicalName:  " + someClass.getCanonicalName() + '\n'
                        + "getSimpleName:  " + someClass.getSimpleName() + '\n'
                        + "getTypeName:  " + someClass.getTypeName() + '\n'
        );
    }
}
