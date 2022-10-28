package corejava.chapter6.lab1;


import java.util.ArrayList;
import java.util.List;

public class Stack<E> {

    List<E> array;

    public Stack (){
        array = new ArrayList<>();
    }

    public boolean push(E item) {
        return array.add(item);
    }

    public E pop() {
        return array.remove(array.size()-1);
    }

    public boolean isEmpty() {
        return array.size() == 0;
    }
}
