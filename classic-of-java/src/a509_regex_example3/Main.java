package a509_regex_example3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String source = "A broken hand works, but not a broken heart.";
        String regex = "broken";
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);

        while (matcher.find()) {
            System.out.println(matcher.start() + "~" + matcher.end());
            matcher.appendReplacement(sb, "drunken");
            System.out.println(sb.toString());
            System.out.println("---------------------------------------");
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }
}
