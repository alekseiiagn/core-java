package corejava.chapter3.lab6;

import java.util.Iterator;

public class DigitSequence implements Iterator<Integer> {

    private int number;

    DigitSequence(int number){this.number=number;}

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }

    @Override
    public void remove() {
    }
}
