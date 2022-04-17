package corejava.chapter3.lab1_2;

public class Employee implements Measurable {

    private final String name;
    private final double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getMeasure() {
        return salary;
    }

    @Override
    public String toString() {
        return "{ name: " + name + ", salary: " + salary + '}';
    }
}
