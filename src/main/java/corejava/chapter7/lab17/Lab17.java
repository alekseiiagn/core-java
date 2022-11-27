package corejava.chapter7.lab17;

import java.util.ArrayList;
import java.util.Collections;

public class Lab17 {

/*
    @SuppressWarnings("unchecked")
    E typeCheck(Object o) {
        if (o != null && !type.isInstance(o))
            throw new ClassCastException(badElementMsg(o));
        return (E) o;
    }

    private String badElementMsg(Object o) {
        return "Attempt to insert " + o.getClass() +
                " element into collection with element type " + type;
    }
*/

    public static void main(String[] args) {
        Collections.checkedList(new ArrayList<>(), String.class);
    }
}
