package corejava.chapter1.lab12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * В JDK не нашел, по этому привел свой пример
 */
public class Lab12 {
    public static void main(String[] args) {

        List<List<Integer>> arr = createRandomArray();
        withOuter(arr);
        withoutOuter(arr);
    }

    private static List<List<Integer>> createRandomArray() {
        Random rand = new Random();
        int randCountI = rand.nextInt(100);
        int randCountJ = rand.nextInt(100);
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < randCountI; i++) {
            arr.add(new ArrayList<>());
            for (int j = 0; j < randCountJ; j++) {
                arr.get(i).add(rand.nextInt(randCountJ * 2));
            }
        }
        return arr;
    }

    public static void withOuter(List<List<Integer>> arr) {
        outer:
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).size() > 5) {
                System.out.printf("Arr[%d]:\n", i);
                for (int j = 0; j < arr.get(i).size(); j++) {
                    if (arr.get(i).get(j) > arr.get(i).size()) {
                        System.out.println(arr.get(i).get(j));
                    } else {
                        break outer;
                    }
                }
            }
        }
    }

    public static void withoutOuter(List<List<Integer>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).size() > 5) {
                System.out.printf("Arr[%d]:\n", i);
                for (int j = 0; j < arr.get(i).size(); j++) {
                    if (arr.get(i).get(j) > arr.get(i).size()) {
                        System.out.println(arr.get(i).get(j));
                    } else {
                        break;
                    }
                }
                break;
            }
        }

    }
}
