package corejava.chapter6.lab17;

import java.lang.reflect.Method;

import static corejava.chapter6.lab25.Lab25.genericDeclaration;

public class Lab17 {
    public static void main(String[] args) {
        Method[] methods = Employee.class.getMethods();
        for (Method method : methods) {
            System.out.println(genericDeclaration(method));
        }
    }
}
