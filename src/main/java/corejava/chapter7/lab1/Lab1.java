package corejava.chapter7.lab1;

import java.util.*;

public class Lab1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getPrimesHashSetLessThan(100)));
        System.out.println(Arrays.toString(getPrimesBitSetLessThan(100)));

    }

    public static Integer[] getPrimesHashSetLessThan(int number) {
        HashSet<Integer> hashSet = new HashSet<>(number);
        for (int i = 2; i < number; i++) {
            hashSet.add(i);
        }
        for (int min = 2; min * min < number; min++) {
            for (int j = min * min; j < number; j += min) {
                hashSet.remove(j);
            }
        }
        return hashSet.toArray(new Integer[0]);
    }

    public static Integer[] getPrimesBitSetLessThan(int number) {
        BitSet bitSet = new BitSet(number);
        bitSet.set(2, number - 1, true);
        for (int min = 2; min * min < number; min++) {
            if (bitSet.get(min)) {
                for (int j = min * min; j < bitSet.length(); j += min) {
                    bitSet.set(j, false);
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < bitSet.length(); i++) {
            if (bitSet.get(i)) {
                primes.add(i);
            }
        }
        return primes.toArray(new Integer[0]);
    }
}
