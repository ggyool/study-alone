package a508_regex_example2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String source = "HP:011-1111-1111, HOME:02-999-9999 ";
        String regex = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher =pattern.matcher(source);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group());
            System.out.println(matcher.group(1) + "," + matcher.group(2) + "," + matcher.group(3));
            System.out.println("-----------------------------------");
        }
    }
}
