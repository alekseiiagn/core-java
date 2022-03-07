package corejava.chapter2.lab9;

/*
 Реализуйте класс Саг, моделирующий передвижение автомобиля на бензиновом
 топливе по оси х. Предоставьте методы для передвижения автомобиля на
 заданное количество километров, заполнения топливного бака заданным
 количеством литров бензина, вычисления расстояния, пройденного от начала
 координат, а также уровня топлива в баке. Укажите расход топлива (в км/л)
 в качестве параметра конструктора данного класса.

 Должен ли этот класс быть неизменяемым и почему?
 */

public class Car {
    private double x;
    private double fuel;

    private final int maxFuel;
    private final double consumption;

    public Car(int maxFuel, double consumption) {
        if (consumption < 0)
            throw new RuntimeException("Consumption < 0!");
        this.x = 0;
        this.fuel = 0;
        this.maxFuel = maxFuel;
        this.consumption = consumption;
    }

    public Car(int maxFuel, double consumption, double fuel) {
        this(maxFuel, consumption);
        addFuel(fuel);
    }

    public Car(int maxFuel, double consumption, double fuel, double x) {
        this(maxFuel, consumption);
        this.x = x;
        addFuel(fuel);
    }

    public double getX() {
        return x;
    }

    public double getFuel() {
        return fuel;
    }

    public double getConsumption() {
        return consumption;
    }


    private double spendFuel(double x) {
        double spend = x / consumption;
        if (fuel <= spend) {
            double s = fuel * consumption;
            fuel = 0;
            return s;
        } else {
            fuel -= spend;
            return x;
        }
    }

    public boolean addX(double x) {
        double s = spendFuel(x);
        this.x += s;
        return s == x;
    }

    public void addFuel(double fuel) {
        if (fuel + this.fuel > maxFuel) {
            throw new RuntimeException("So more fuel!");
        }
        if (fuel + this.fuel < 0)
            throw new RuntimeException("Fuel < 0!");

        this.fuel += fuel;
    }
}
