package corejava.chapter3.lab6;

public class Lab6 {
    public static void main(String[] args) {
        DigitSequence digitSequence = new DigitSequence(1);

        digitSequence.remove();
        digitSequence.forEachRemaining(Object::toString);
    }
}
