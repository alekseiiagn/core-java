package corejava.chapter4.additional;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

public final class DIServiceLoader<T> {

    private static final String PATH = "src/main/resources/chapter4/META-INF/services/";
    String name;
    ServiceLoader<T> serviceLoader;
    Map<String, T> beans;

    private DIServiceLoader(Class<T> cl) {
        name = cl.getName();
        beans = new HashMap<>();
        serviceLoader = ServiceLoader.load(cl);
    }

    public static <T> DIServiceLoader<T> load(Class<T> cl) {
        return new DIServiceLoader<>(cl);
    }

    public T getBean(String beanName) throws ClassNotFoundException, IOException {
        FileReader fileReader = new FileReader(PATH + name);
        try (BufferedReader reader = new BufferedReader(fileReader)) {

            int i;
            for (i = 0; true; i++) {
                String line = reader.readLine();
                if (line == null) {
                    throw new ClassNotFoundException(beanName + " not found in" + PATH + name);
                }
                String[] value = line.split("#");
                String name1 = value[value.length - 1];
                if (beans.containsKey(name1)) {
                    System.out.print("Bean->");
                    return beans.get(name1);
                } else if (name1.equals(beanName)) {
                    break;
                }
            }

            Iterator<T> iterator = serviceLoader.iterator();
            for (int j = 0; j < i; j++) {
                iterator.next();
            }
            T bean = iterator.next();
            beans.put(beanName, bean);
            System.out.print("ServiceLoader->");
            return bean;
        }
    }

    public T getBean(Class<?> beanClass) {
        return serviceLoader.stream()
                .filter(o -> o.get().getClass().equals(beanClass))
                .findFirst()
                .get()
                .get();
    }

    public Iterator<T> iterator() {
        return serviceLoader.iterator();
    }
}
