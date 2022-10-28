package corejava.chapter6.lab17;

public class Employee implements Comparable<Employee> {

    private final String name;
    private final double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee o) {
        return (int) (this.salary - o.salary);
    }

    @Override
    public String toString() {
        return "{ name: " + name + ", salary: " + salary + '}';
    }
}
