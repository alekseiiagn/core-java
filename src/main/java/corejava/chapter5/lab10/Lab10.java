package corejava.chapter5.lab10;

import java.util.Arrays;

public class Lab10 {
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

    public static int factorial(int number){
        if (number==1){
            return 1;
        }
        //TODO так?
        Arrays.stream(new RuntimeException().getStackTrace()).forEach(System.out::println);
        return factorial(number-1)*number;
    }
}
