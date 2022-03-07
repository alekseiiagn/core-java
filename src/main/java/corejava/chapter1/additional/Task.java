package corejava.chapter1.additional;

import java.math.BigInteger;

public class Task {

    /*
     * внутри хранится массив int
     * реализовать класс BigInteger со следующими методами toLong(), toString(), add(), valueOf()
     */

    public static void main(String[] args) {

        long first = Integer.MAX_VALUE;
        long second = Integer.MAX_VALUE;

        MyBigInteger myBigInteger = MyBigInteger.valueOf(first);
        BigInteger bigInteger1 = BigInteger.valueOf(first);

        BigInteger res1 = bigInteger1.add(BigInteger.valueOf(second));
        MyBigInteger res2 = myBigInteger.add(MyBigInteger.valueOf(second));

        System.out.println("1:" + res1 + " 2:" + res2.toLong());

    }
}
