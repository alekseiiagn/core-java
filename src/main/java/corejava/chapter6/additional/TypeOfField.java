package corejava.chapter6.additional;

import corejava.chapter6.lab3.Entry;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

public class TypeOfField {

    public static void main(String[] args) {
        EntryFoo entrySS0 = new EntryFoo("key", "value");
        System.out.println(getTypeOfField(entrySS0, "key"));

        EntryStringString entrySS1 = new EntryStringString("key", "value");
        System.out.println(getTypeOfField(entrySS1, "key"));

        Entry<String, String> entry = new Entry<>("key", "value");
        System.out.println(getTypeOfField(entry, "key"));

        Generic<String> generic = new Generic<>("hello");
        System.out.println(getTypeOfField(generic, "value"));
    }

    public static <T> String getTypeOfField(T object, String field) {
        return getField(object.getClass(), null, field);
    }

    private static <T> String getField(Class<T> clazz, Type type, String fieldName) {
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
        return getField(clazz.getSuperclass(), clazz.getGenericSuperclass(), fieldName);
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

    static class EntryFoo extends EntryStringString{

        public EntryFoo(String key, String value) {
            super(key, value);
        }
    }
    static class EntryStringString extends Entry<String, String> {
        public EntryStringString(String key, String value) {
            super(key, value);
        }
    }

    static class Generic<T extends String> {
        private final T value;

        public Generic(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }
}
