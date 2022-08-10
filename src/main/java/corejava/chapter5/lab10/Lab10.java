package corejava.chapter5.lab10;

import java.util.Arrays;

public class Lab10 {
    public static void main(String[] args) {
        //System.out.println(factorial(4));
        try {
            System.out.println(factorial1(4));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static int factorial(int number) {
        if (number == 1) {
            return 1;
        }
        Arrays.stream(new RuntimeException().getStackTrace()).forEach(System.out::println);
        return factorial(number - 1) * number;
    }

    public static int factorial1(int number) {
        if (number == 1) {
            throw new RuntimeException("1");
        }

        int f;
        try {
            f = factorial1(number - 1) * number;
        } catch (RuntimeException e) {
            throw new RuntimeException(Integer.toString(Integer.parseInt(e.getMessage()) * number), e);
        }
        return f;
    }


}
