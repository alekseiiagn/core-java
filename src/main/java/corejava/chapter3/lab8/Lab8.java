package corejava.chapter3.lab8;

public class Lab8 {
    public static void main(String[] args) {

        Runnable greeter1 = new Greeter(100, "Aleksei");
        Runnable greeter2 = new Greeter(100, "Grigory");

        Thread thread1 = new Thread(greeter1);
        Thread thread2 = new Thread(greeter2);

        thread1.start();
        thread2.start();
    }
}
