package corejava.chapter1.additional;

import java.math.BigInteger;

public class Task {
/*    BigInteger;
    BigDecimal;*/
    /*
     * внутри хранится массив int
     * реализовать класс BigInteger со следующими методами fromLong(), toString(), plus()
     */

    public static void main(String[] args) {

        MyBigInteger myBigInteger = MyBigInteger.valueOf(Long.MAX_VALUE-1);
        System.out.println(myBigInteger.toLong());

        BigInteger bigInteger1 = BigInteger.valueOf(Long.MAX_VALUE-1);

        BigInteger res1 = bigInteger1.add(BigInteger.valueOf(1));
        MyBigInteger res2 = myBigInteger.add(MyBigInteger.valueOf(1));

        System.out.println("1:" + res1.toString(2) + " 2:" + res2);
        //System.out.println("1:" + res1 + " 2:" + res2.toLong());

/*        System.out.println("1:" + bigInteger1.toString(2) + " 2:" + myBigInteger);

        System.out.println("1:" + bigInteger1 + " 2:" + myBigInteger.fromLong());*/
    }
}
