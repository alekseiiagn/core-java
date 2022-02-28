package corejava.chapter1.additional;

import java.util.ArrayList;
import java.util.List;

public class MyBigInteger {
    int[] mag;
    int sign;

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

    private static int[] add(int[] it, int[] other) {
        List<Integer> result = new ArrayList<>();
        int minSize, maxSize;
        if (it.length < other.length) {
            minSize = it.length;
            maxSize = other.length;
        } else {
            minSize = other.length;
            maxSize = it.length;
        }

        int highWorld = 0;
        for (int i = maxSize - 1; i >= 0; i--) {

            int val1 = 0, val2 = 0;
            if (i < it.length)
                val1 = it[i];
            if (i < other.length)
                val2 = other[i];

            long resVal = (long) val1 + val2 - highWorld;
            highWorld = (int) (resVal >>> 32);
            result.add((int) resVal);
        }

        if (highWorld != 0) {
            int lastIndex = result.size() - 1;
            result.set(lastIndex, result.get(lastIndex) - highWorld);
        }

        int[] res = new int[result.size()];
        for (int i = result.size() - 1, j = 0; i >= 0; i--, j++) {
            res[j] = result.get(i);
        }
        return res;
    }

    public MyBigInteger add(MyBigInteger other) {
        if (other.sign == sign)
            return new MyBigInteger(add(this.mag, other.mag), sign);
        else return null;
    }

    /*
    MyBigInteger add(long val) {
        if (val == 0)
            return this;
        if (sign == 0)
            return valueOf(val);
        if (Long.signum(val) == sign)
            return new BigInteger(add(mag, Math.abs(val)), sign);
        int cmp = compareMagnitude(val);
        if (cmp == 0)
            return ZERO;
        int[] resultMag = (cmp > 0 ? subtract(mag, Math.abs(val)) : subtract(Math.abs(val), mag));
        resultMag = trustedStripLeadingZeroInts(resultMag);
        return new BigInteger(resultMag, cmp == sign ? 1 : -1);
    }*/
    @Override
    public String toString() {
        MyBigInteger myBigInteger = this.abs();
        StringBuilder stringBuilder = new StringBuilder(sign == 1 ? "" : "-");
        for (int it : myBigInteger.mag) {
            if (it == 0) {
                stringBuilder.append("00000000000000000000000000000000");
            } else {
                stringBuilder.append(Integer.toBinaryString(it));
            }
        }

        return stringBuilder.toString();
    }

    /*
    private static final int SCHOENHAGE_BASE_CONVERSION_THRESHOLD = 20;

    public String toString() {
        if (sign == 0)
            return "0";

        // If it's small enough, use smallToString.
        if (mag.length <= SCHOENHAGE_BASE_CONVERSION_THRESHOLD)
            return smallToString();

        // Otherwise use recursive toString, which requires positive arguments.
        // The results will be concatenated into this StringBuilder
        StringBuilder sb = new StringBuilder();
        if (sign < 0) {
            toString(this.negate(), sb, 0);
            sb.insert(0, '-');
        } else
            toString(this, sb, 0);

        return sb.toString();
    }

    public long longValue() {
        long result = 0;

        for (int i = 1; i >= 0; i--)
            result = (result << 32) + (getInt(i) & LONG_MASK);
        return result;
    }

    private static int digitsPerLong[] = {0, 0,
            62, 39, 31, 27, 24, 22, 20, 19, 18, 18, 17, 17, 16, 16, 15, 15, 15, 14,
            14, 14, 14, 13, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 12, 12, 12};




    private static int digitsPerInt[] = {0, 0, 30, 19, 15, 13, 11,
            11, 10, 9, 9, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 6, 6, 6, 6,
            6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5};

    private static int intRadix[] = {0, 0,
            0x40000000, 0x4546b3db, 0x40000000, 0x48c27395, 0x159fd800,
            0x75db9c97, 0x40000000, 0x17179149, 0x3b9aca00, 0xcc6db61,
            0x19a10000, 0x309f1021, 0x57f6c100, 0xa2f1b6f,  0x10000000,
            0x18754571, 0x247dbc80, 0x3547667b, 0x4c4b4000, 0x6b5a6e1d,
            0x6c20a40,  0x8d2d931,  0xb640000,  0xe8d4a51,  0x1269ae40,
            0x17179149, 0x1cb91000, 0x23744899, 0x2b73a840, 0x34e63b41,
            0x40000000, 0x4cfa3cc1, 0x5c13d840, 0x6d91b519, 0x39aa400
    };


    private String smallToString() {
        if (sign == 0) {
            return "0";
        }

        int radix = 10;
        // Compute upper bound on number of digit groups and allocate space
        int maxNumDigitGroups = (4 * mag.length + 6) / 7;
        String digitGroup[] = new String[maxNumDigitGroups];

        int numGroups = 0;

        digitGroup[numGroups++] = Long.toString(this.abs().longValue(), radix);

        // Put sign (if any) and first digit group into result buffer
        StringBuilder buf = new StringBuilder(0);
        if (sign < 0) {
            buf.append('-');
        }
        buf.append(digitGroup[numGroups - 1]);

        // Append remaining digit groups padded with leading zeros
        for (int i = numGroups - 2; i >= 0; i--) {
            // Prepend (any) leading zeros for this digit group
            int numLeadingZeros = digitsPerLong[radix] - digitGroup[i].length();
            if (numLeadingZeros != 0) {
                buf.append(zeros[numLeadingZeros]);
            }
            buf.append(digitGroup[i]);
        }
        return buf.toString();
    }

    private static void toString(MyBigInteger u, StringBuilder sb,
                                 int digits) {
        int radix = 10;

        if (u.mag.length <= SCHOENHAGE_BASE_CONVERSION_THRESHOLD) {
            String s = u.smallToString();

            // Pad with internal zeros if necessary.
            // Don't pad if we're at the beginning of the string.
            if ((s.length() < digits) && (sb.length() > 0)) {
                for (int i = s.length(); i < digits; i++) { // May be a faster way to
                    sb.append('0');                    // do this?
                }
            }

            sb.append(s);
            return;
        }

        int b, n;
        b = u.bitLength();

        // Calculate a value for n in the equation radix^(2^n) = u
        // and subtract 1 from that value.  This is used to find the
        // cache index that contains the best value to divide u.
        n = (int) Math.round(Math.log(b * LOG_TWO / logCache[radix]) / LOG_TWO - 1.0);
        MyBigInteger v = getRadixConversionCache(radix, n);
        MyBigInteger[] results;
        results = u.divideAndRemainder(v);

        int expectedDigits = 1 << n;

        // Now recursively build the two halves of each number.
        toString(results[0], sb, digits - expectedDigits);
        toString(results[1], sb, expectedDigits);
    }


    private static MyBigInteger getRadixConversionCache(int radix, int exponent) {
        MyBigInteger[] cacheLine = powerCache[radix]; // volatile read
        if (exponent < cacheLine.length) {
            return cacheLine[exponent];
        }

        int oldLength = cacheLine.length;
        cacheLine = Arrays.copyOf(cacheLine, exponent + 1);
        for (int i = oldLength; i <= exponent; i++) {
            cacheLine[i] = cacheLine[i - 1].pow(2);
        }

        MyBigInteger[][] pc = powerCache; // volatile read again
        if (exponent >= pc[radix].length) {
            pc = pc.clone();
            pc[radix] = cacheLine;
            powerCache = pc; // volatile write, publish
        }
        return cacheLine[exponent];
    }

    private static String zeros[] = new String[64];

    static {
        zeros[63] =
                "000000000000000000000000000000000000000000000000000000000000000";
        for (int i = 0; i < 63; i++)
            zeros[i] = zeros[63].substring(0, i);
    }
*/

}
