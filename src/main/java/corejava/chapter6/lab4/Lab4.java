package corejava.chapter6.lab4;

import java.util.Random;

public class Lab4 {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 20;
    private static final Random random = new Random();

    public static void main(String[] args) {
        Table<Integer, Integer> table = createRandomTableBySize(20);
        print(table);
        changeValues(table);
        print(table);
    }

    private static Table<Integer, Integer> createRandomTableBySize(int count) {

        Table<Integer, Integer> table = new Table<>();
        for (int i = 0; i < count; i++) {
            table.add(i, random.nextInt(MIN_NUMBER, MAX_NUMBER));
        }
        return table;
    }

    private static void print(Table<Integer, ?> table) {
        for (int i = 0; i < table.size(); i++) {
            System.out.println(i + " " + table.get(i));
        }
    }

    private static void changeValues(Table<Integer, Integer> table) {
        for (int i = 0; i < table.size(); i++) {
            table.set(i, random.nextInt(MIN_NUMBER, MAX_NUMBER));
        }
    }
}
