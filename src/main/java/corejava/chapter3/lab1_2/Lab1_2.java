package corejava.chapter3.lab1_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lab1_2 {
    private static final Random rand = new Random();

    public static void main(String[] args) {
        Employee[] employees = createRandomListEmployees();
        try {
            System.out.println("Average salary: " + Measurable.average(employees));
            Employee employee = (Employee) (Measurable.largest(employees));
            System.out.println("Employee's name with largest salary: " + employee.getName());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Employee[] createRandomListEmployees() {
        List<Employee> employees = new ArrayList<>();
        String[] names = {"Alex", "Sasha", "Mike", "Stiven", "Jek", "Bob"};
        int count = rand.nextInt(30);
        for (int i = 0; i < count; i++) {
            employees.add(new Employee(names[rand.nextInt(names.length - 1)], rand.nextInt(25_000, 150_000)));
        }
        return employees.toArray(new Employee[0]);
    }
}
