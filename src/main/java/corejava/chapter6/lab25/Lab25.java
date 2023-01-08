package corejava.chapter6.lab25;

import corejava.chapter6.lab12_13.Lab12_13;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;

public class Lab25 {

    public static void main(String[] args) {
        System.out.println(getDeclarationMethodByClassAndName(Lab12_13.class, "minmax"));
    }

    private static String getDeclarationMethodByClassAndName(Class<?> cl, String methodName) {
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return genericDeclaration(method);
            }
        }
        return "";
    }

    public static String genericDeclaration(Method m) {
        return new StringBuilder()
                .append(parse(m.getModifiers()))
                .append(" ")
                .append(parse(m.getTypeParameters()))
                .append(" ")
                .append(m.getGenericReturnType())
                .append(" ")
                .append(m.getName())
                .append(" ")
                .append(parse(m.getParameters()))
                .toString();
    }

    private static String parse(int modifier) {
        return Modifier.toString(modifier);
    }

    private static String parse(TypeVariable<Method>[] typeParameters) {
        return "<" + arrayToString(typeParameters) + ">";
    }

    private static String parse(Parameter[] genericTypes) {
        return "(" + arrayToString(genericTypes) + ")";
    }

    private static <T> String arrayToString(T[] genericTypes) {
        StringBuilder sb = new StringBuilder();
        if (genericTypes.length > 0) {
            sb.append(genericTypes[0]);
        }
        for (int i = 1; i < genericTypes.length; i++) {
            sb.append(", ").append(genericTypes[i]);
        }
        return sb.toString();
    }

    private static String parseRealTypes(TypeVariable<Method>[] genericTypes) {
        StringBuilder sb = new StringBuilder("<");
        if (genericTypes.length > 0) {
            sb.append(toRightSite(genericTypes, 0));
        }
        for (int i = 1; i < genericTypes.length; i++) {
            sb.append(", ").append(toRightSite(genericTypes, i));
        }
        return sb.append(">").toString();
    }

    private static String toRightSite(TypeVariable<Method>[] genericTypes, int x) {
        return genericTypes[x].getBounds()[0].getTypeName();
    }
}
