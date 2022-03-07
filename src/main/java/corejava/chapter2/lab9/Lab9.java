package corejava.chapter2.lab9;

public class Lab9 {
    public static void main(String[] args) {
        Car car = new Car(60, 10, 45);
        car.addFuel(15);
        System.out.println(car.getFuel());
        car.addX(1000);
        System.out.println(car.getFuel());
        System.out.println(car.getX());
    }
}
