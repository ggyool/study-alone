package a473_encoding_example;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        String s = "가나다";
        System.out.println(Charset.availableCharsets());
        try {
            byte[] utf8 = s.getBytes("UTF-8");
            byte[] cp949 = s.getBytes("CP949");

            System.out.println(joinByteArr(utf8));
            System.out.println(joinByteArr(cp949));

            System.out.println(new String(utf8, "UTF-8"));
            System.out.println(new String(cp949, "CP949"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static String joinByteArr(byte[] barr) {
        StringJoiner sj = new StringJoiner(":", "[", "]");
        for (byte b : barr) {
            sj.add(String.format("%02X", b));
        }
        return sj.toString();
    }
}
