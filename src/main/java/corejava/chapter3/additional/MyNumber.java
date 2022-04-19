package corejava.chapter3.additional;

public class MyNumber {
    private final int x;

    MyNumber(int x) {
        this.x = x;
    }

    public boolean moreThen(MyNumber myNumber1) {
        return myNumber1.x > this.x;
    }

    static public boolean moreThenTen(MyNumber myNumber) {
        return myNumber.x > 10;
    }

    public boolean moreThenFive() {
        return this.x > 10;
    }

    @Override
    public String toString() {
        return Integer.toString(this.x);
    }
}
