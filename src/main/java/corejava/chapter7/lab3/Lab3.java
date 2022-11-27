package corejava.chapter7.lab3;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lab3 {

    public static void main(String[] args) {
        Set<Integer> set1 = generateRandomSet(5, 20);
        System.out.println(set1);
        Set<Integer> set2 = generateRandomSet(5, 20);
        System.out.println(set2);

        System.out.println("Union: " + union(set1, set2));
        System.out.println("Intersection: " + intersection(set1, set2));
        System.out.println("Difference: " + difference(set1, set2));
    }

    public static Set<Integer> generateRandomSet(int origin, int bound) {
        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        int count = random.nextInt(origin, bound);
        for (int i = 0; i < count; i++) {
            set.add(random.nextInt(origin, bound));
        }
        return set;
    }

    public static Set<Integer> union(Set<Integer> first, Set<Integer> second) {
        Set<Integer> copyOfFirst = new HashSet<>(first);
        copyOfFirst.addAll(second);
        return copyOfFirst;
    }

    public static Set<Integer> intersection(Set<Integer> first, Set<Integer> second) {
        Set<Integer> copyOfFirst = new HashSet<>(first);
        Set<Integer> copyOfSecond = new HashSet<>(second);
        copyOfFirst.retainAll(second);
        copyOfSecond.retainAll(copyOfFirst);
        return copyOfSecond;
    }

    public static Set<Integer> difference(Set<Integer> first, Set<Integer> second) {
        Set<Integer> copyOfFirst = new HashSet<>(first);
        copyOfFirst.removeAll(second);
        return copyOfFirst;
    }
}
