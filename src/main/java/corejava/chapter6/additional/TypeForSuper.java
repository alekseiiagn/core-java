package corejava.chapter6.additional;

import java.lang.reflect.Method;

public class TypeForSuper {

    public static void main(String[] args) {
        System.out.println(getDeclarationMethodByClassAndName(TypeForSuper.class, "typeForSuper"));
    }
    private static String getDeclarationMethodByClassAndName(Class<?> cl, String methodName) {
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return method.toString();
            }
        }
        return "";
    }
}
