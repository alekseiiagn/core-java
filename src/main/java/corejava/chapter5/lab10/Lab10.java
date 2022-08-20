package corejava.chapter5.lab10;

import java.util.Arrays;

public class Lab10 {
    public static void main(String[] args) {
        System.out.println(factorialWithStackTrace(4));
        try {
            System.out.println(factorialWithExceptions(4));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static int factorialWithStackTrace(int number) {
        if (number == 1) {
            return 1;
        }
        Arrays.stream(new RuntimeException().getStackTrace()).forEach(System.out::println);
        return factorialWithStackTrace(number - 1) * number;
    }

    public static int factorialWithExceptions(int number) {
        if (number == 1) {
            throw new RuntimeException("1");
        }
        int result;
        try {
            result = factorialWithExceptions(number - 1) * number;
        } catch (RuntimeException e) {
            throw new RuntimeException(Integer.toString(Integer.parseInt(e.getMessage()) * number), e);
        }
        return result;
    }


}
