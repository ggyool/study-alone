package a520_biginteger_example;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger[] fact = new BigInteger[51];
        fact[0] = BigInteger.valueOf(1L);
        for (int i = 1; i <= 50; i++) {
            fact[i] = fact[i-1].multiply(BigInteger.valueOf(i));
        }
        for (int i = 0; i <= 50; i++) {
            System.out.println(i + "!:" + fact[i].toString());
        }
    }
}
