package corejava.chapter3.lab4_5;

public class Lab4_5 {

    public static void main(String[] args) {
        IntSequence intSequence = IntSequence.of(3, 1, 4, 1, 5, 9);
        while (intSequence.hasNext()) {
            System.out.println(intSequence.next());
        }

        IntSequence intSequence1 = IntSequence.constant(1);
        while (intSequence1.hasNext()) {
            System.out.println(intSequence1.next());
        }
    }
}