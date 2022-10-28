package corejava.chapter1.lab15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab15 {
    public static void main(String[] args) {
        getRow(3);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter int number:");
        if (in.hasNextInt()) {
            print(createArray(in.nextInt()));
        } else {
            throw new RuntimeException("It's not int number!");
        }
    }

    private static List<List<Integer>> createArray(int numRows) {
        List<List<Integer>> arr = new ArrayList<>(numRows);
        arr.add(new ArrayList<>());
        arr.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            arr.add(new ArrayList<>());
            arr.get(i).add(1);
            for (int j = 1; j < i; j++) {
                int a = arr.get(i - 1).get(j - 1);
                int b = arr.get(i - 1).get(j);
                arr.get(i).add(a + b);
            }
            arr.get(i).add(1);
        }
        return arr;
    }

    private static List<Integer> getRow(int rowIndex){
        List<Integer> row = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            row.add(0,1);
            for(int j = 1; j < i; j++){
                row.set(j, row.get(j) + row.get(j+1));
            }
        }
        return row;
    }


    public static void print(List<List<Integer>> arr) {
        for (List<Integer> list : arr) {
            System.out.println(list);
        }
    }
}
