package corejava.chapter7.lab4;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static corejava.chapter6.lab6.Lab6.createRandomArrayBySize;

public class Lab4 {

    public static void main(String[] args) {
        List<Integer> list = createRandomArrayBySize(10);
        System.out.println(list);

//        removeCorrect1(list, 10);
        removeCorrect2(list, 10);
//        removeIncorrect(list, 10);
        System.out.println(list);
    }

    public static <T> void removeIncorrect(Collection<T> collection, T object) {
        for (T data : collection) {
            if (data.equals(object)) {
                collection.remove(data);
            }
        }
    }

    public static <T> void removeCorrect1(Collection<T> collection, T object) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().equals(object)){
                iterator.remove();
            }
        }
    }

    public static <T> void removeCorrect2(Collection<T> collection, T object) {
        collection.removeIf(t -> t.equals(object)); //внутри по сути removeCorrect2
    }
}
