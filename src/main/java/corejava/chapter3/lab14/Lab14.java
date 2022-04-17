package corejava.chapter3.lab14;

import corejava.chapter3.lab1_2.Employee;
import corejava.chapter3.lab1_2.Lab1_2;

import java.util.Arrays;
import java.util.Comparator;

public class Lab14 {
    public static void main(String[] args) {
        Arrays.sort(Lab1_2.createRandomListEmployees(), Comparator.comparing(Employee::getMeasure).thenComparing(Employee::getName));
    }
}
