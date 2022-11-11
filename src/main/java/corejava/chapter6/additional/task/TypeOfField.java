package corejava.chapter6.additional.task;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TypeOfField {

    public static void main(String[] args) {

        EntryFoo entrySS0 = new EntryFoo(1, "value");
        System.out.println(getSubclasses(entrySS0, "key"));

        EntryStringString entrySS1 = new EntryStringString(1, "value");
        System.out.println(getSubclasses(entrySS1, "key"));

        Generic<String> generic = new Generic<>("hello");
        System.out.println(getSubclasses(generic, "value"));
    }

    public static <T> List<Class<?>> getSubclasses(T object, String field) {
        String className = getTypeOfField(object, field);
        return getSubclassesOfClass(className);
    }

    public static <T> String getTypeOfField(T object, String field) {
        return getTypeOfField(object.getClass(), null, field);
    }

    private static <T> String getTypeOfField(Class<T> clazz, Type type, String fieldName) {
        Field[] fields = clazz.getDeclaredFields();
        List<String> genericTypes = List.of(getGenericTypes(type));
        int count = 0;
        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                if (!genericTypes.isEmpty() && isGenericType(field)) {
                    return genericTypes.get(count);
                } else {
                    return field.getType().getTypeName();
                }
            }
            if (isGenericType(field)) {
                count++;
            }
        }
        return getTypeOfField(clazz.getSuperclass(), clazz.getGenericSuperclass(), fieldName);
    }

    private static String[] getGenericTypes(Type type) {
        if (type == null || !type.getTypeName().contains("<")) {
            return new String[0];
        }
        String typeName = type.getTypeName();
        int start = typeName.indexOf('<') + 1;
        int finish = typeName.length() - 1;
        return typeName
                .substring(start, finish)
                .split(", ");
    }

    private static boolean isGenericType(Field field) {
        return field.getGenericType().getClass().getSimpleName().equals("TypeVariableImpl");
    }

    public static List<Class<?>> getSubclassesOfClass(String className) {
        try {
            Class<?> parent = Class.forName(className);
            return getClassesFromClassPath().stream()
                    .filter(parent::isAssignableFrom)
                    .toList();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class name is incorrect!", e);
        } catch (IOException e) {
            throw new RuntimeException("Error system class loader!", e);
        }
    }

    private static List<Class<?>> getClassesFromClassPath() throws IOException {
        ClassPath classPath = ClassPath.from(ClassLoader.getSystemClassLoader());
        List<Class<?>> classes = new ArrayList<>();
        ImmutableSet<ClassPath.ResourceInfo> resources = classPath.getResources();
        for (ClassPath.ResourceInfo resource : resources) {
            try {
                classes.add(Class.forName(resource.toString()));
            } catch (ClassNotFoundException | NoClassDefFoundError ignored) {}
        }
        return classes;
    }
}
