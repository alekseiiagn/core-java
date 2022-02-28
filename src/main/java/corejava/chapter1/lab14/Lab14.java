package corejava.chapter1.lab14;

import java.util.*;
import java.util.stream.Collectors;

public class Lab14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<List<Integer>> matrix = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = 0;
        while (true) {
            System.out.print("Enter string numbers:");
            String str = in.nextLine();
            if (str.length() > 0) {
                String[] numbers = str.trim().split("\\s+");

                matrix.add(Arrays.stream(numbers)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));
/*                List<Integer> arr = new ArrayList<>();
                for(int i=0; i< numbers.length;i++){
                    arr.add(Integer.parseInt(numbers[i]));
                }
                matrix.add(arr);*/

                if (minX > numbers.length) minX = numbers.length;
                minY++;

            } else break;
        }
        System.out.println(checkMatrix(matrix, minX, minY));
    }

    public static boolean checkMatrix(List<List<Integer>> matrix, int minX, int minY) {
        //проходимся по всей матрице
        for (int x = 0; x < minX; x++) {
            for (int y = 0; y < minY; y++) {
                //выбираем все стороны
                for (int size = 2; size <= Math.min(minX - x, minY - y); size++) {
                    //просматриваем квадрат по определенным координатам с определенной стороной
                    if (checkSquare(matrix, x, y, size)) return true;
                }
            }
        }
        return false;
    }

/*    public static void printSquare(List<List<Integer>> matrix, int x, int y, int size) {
        for (int i = x; i < size + x; i++) {
            for (int j = y; j < size + y; j++) {
                System.out.printf("%d ", matrix.get(j).get(i));
            }
            System.out.println();
        }
        System.out.println();
    }*/

    public static boolean checkSquare(List<List<Integer>> matrix, int x, int y, int size) {
        int countMagic = checkRightLeftDiagonal(matrix, x, y, size);
        if (countMagic == checkLeftRightDiagonal(matrix, x, y, size)) {
            for (int j = y; j < size + y; j++) {
                if (checkRow(matrix, x, j, size) != countMagic) {
                    return false;
                }
            }
            for (int i = x; i < size + x; i++) {
                if (checkColumn(matrix, i, y, size) != countMagic) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static int checkRow(List<List<Integer>> matrix, int x, int y, int size) {
        int countMagic = 0;
        for (int i = x; i < size + x; i++) {
            countMagic += matrix.get(y).get(i);
        }
        return countMagic;
    }

    public static int checkColumn(List<List<Integer>> matrix, int x, int y, int size) {
        int countMagic = 0;
        for (int j = y; j < size + y; j++) {
            countMagic += matrix.get(j).get(x);
        }
        return countMagic;
    }

    public static int checkRightLeftDiagonal(List<List<Integer>> matrix, int x, int y, int size) {
        int countMagic = 0;
        for (int i = x, j = y; i < size + x && j < size + y; i++, j++) {
            countMagic += matrix.get(j).get(i);
        }
        return countMagic;
    }

    public static int checkLeftRightDiagonal(List<List<Integer>> matrix, int x, int y, int size) {
        int countMagic = 0;
        for (int i = size + x - 1, j = size + y - 1; i >= x && j >= y; i--, j--) {
            countMagic += matrix.get(j).get(i);
        }
        return countMagic;
    }
}
