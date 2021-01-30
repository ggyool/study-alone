package a505_regex_example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String[] data = {"cA", "ca", "ccc", "cbb"};
        Pattern pattern = Pattern.compile("c[a-z]*");
        for (int i = 0; i < data.length; i++) {
            Matcher matcher = pattern.matcher(data[i]);
            if (matcher.matches()) {
                System.out.println(data[i]); // ca, ccc, cbb
            }
        }
    }
}
