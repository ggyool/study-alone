package a521_bigdecimal_test;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("123.45");
        System.out.println(bigDecimal.unscaledValue());
        System.out.println(bigDecimal.scale());
        System.out.println(bigDecimal.precision());

        System.out.println(new BigDecimal("0.1").toString());
        System.out.println(new BigDecimal(0.1).toString());


    }
}
