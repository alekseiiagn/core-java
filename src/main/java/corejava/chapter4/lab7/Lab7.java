package corejava.chapter4.lab7;

public class Lab7 {
    public static void main(String[] args) {

        for (Color color : Color.values()) {
            System.out.println(color);
        }

        System.out.println(Color.getRed());
        System.out.println(Color.getBlue());
        System.out.println(Color.getGreen());
    }
}
