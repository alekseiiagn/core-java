package corejava.chapter3.lab1_2;

import java.util.Arrays;
import java.util.Comparator;

public interface Measurable {

    double getMeasure();

    static double average(Measurable[] objects) {
        return Arrays.stream(objects).mapToDouble(Measurable::getMeasure).average().getAsDouble();
    }

    static Measurable largest(Measurable[] objects) {
        return Arrays.stream(objects).max(Comparator.comparing(Measurable::getMeasure)).get();
    }
}
