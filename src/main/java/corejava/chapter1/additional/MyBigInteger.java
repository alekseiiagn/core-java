package corejava.chapter1.additional;

public class MyBigInteger {

    private final int[] mag;
    private final int sign;
    private static final long LONG_MASK = 0xffffffffL;

    public MyBigInteger(long val) {
        if (val < 0) {
            val = -val;
            sign = -1;
        } else {
            sign = 1;
        }

        int highWord = (int) (val >>> 32);
        if (highWord == 0) {
            mag = new int[1];
            mag[0] = (int) val;
        } else {
            mag = new int[2];
            mag[0] = highWord;
            mag[1] = (int) val;
        }
    }

    MyBigInteger(int[] mag, int sign) {
        this.sign = (mag.length == 0 ? 0 : sign);
        this.mag = mag;
    }

    public static MyBigInteger valueOf(long val) {
        return new MyBigInteger(val);
    }

    private static int[] add(int[] it, int[] other) {

        if (it.length < other.length) {
            int[] tmp = it;
            it = other;
            other = tmp;
        }

        int xIndex = it.length;
        int yIndex = other.length;
        int[] result = new int[xIndex];

        // Cкладываем общие части
        long sum = 0;
        while (yIndex > 0) {
            sum = (it[--xIndex] & LONG_MASK) + (other[--yIndex] & LONG_MASK) + (sum >>> 32);
            result[xIndex] = (int) sum;
        }

        // Переносим оставшееся с учетом того, что было переполнение int
        boolean flagHighWorld = (sum >>> 32 != 0);
        while (xIndex > 0 && flagHighWorld) {
            result[--xIndex] = it[xIndex] + 1;
            flagHighWorld = (result[xIndex] == 0);
        }

        // Переносим оставшееся
        while (xIndex > 0)
            result[--xIndex] = it[xIndex];

        // И если все-таки осталось переполнение, то увеличиваем
        if (flagHighWorld) {
            int[] bigger = new int[result.length + 1];
            System.arraycopy(result, 0, bigger, 1, result.length);
            bigger[0] = 0x01;
            return bigger;
        }

        return result;
    }

    public MyBigInteger add(MyBigInteger other) {
        if (other.sign == 0)
            return new MyBigInteger(this.mag.clone(), this.sign);
        if (sign == 0)
            return new MyBigInteger(other.mag.clone(), other.sign);
        if (other.sign == sign)
            return new MyBigInteger(add(mag, other.mag), sign);
        return null;
    }

    public MyBigInteger negate() {
        return new MyBigInteger(this.mag, -this.sign);
    }

    public MyBigInteger abs() {
        return (sign >= 0 ? this : this.negate());
    }

    public long toLong() {
        if (mag.length > 2) {
            throw new ArithmeticException("It's more then long");
        }
        return Long.parseLong(this.toString(), 2);
    }

    @Override
    public String toString() {
        MyBigInteger myBigInteger = this.abs();
        StringBuilder stringBuilder = new StringBuilder(sign == 1 ? "" : "-");
        for (int it : myBigInteger.mag) {
            stringBuilder.append(intToBinaryString(it));
        }
        return stringBuilder.toString();
    }

    private static String intToBinaryString(int val) {
        StringBuilder binaryString = new StringBuilder();
        String number = Integer.toBinaryString(val);
        for (int i = 0; i < 32 - number.length(); i++) {
            binaryString.append("0");
        }
        return binaryString
                .append(number)
                .toString();
    }
}