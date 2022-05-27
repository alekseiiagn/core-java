package corejava.chapter3.lab1_2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;

public interface Measurable {

    double getMeasure();

    static double average(Measurable... objects) throws IOException {
        OptionalDouble a = Arrays.stream(objects).mapToDouble(Measurable::getMeasure).average();
        if (a.isPresent())
            return a.getAsDouble();
        throw new IOException();
    }

    static Measurable largest(Measurable... objects) throws IOException {
        Optional<Measurable> a = Arrays.stream(objects).max(Comparator.comparing(Measurable::getMeasure));
        if (a.isPresent()) {
            return a.get();
        }
        throw new IOException();
    }
}
