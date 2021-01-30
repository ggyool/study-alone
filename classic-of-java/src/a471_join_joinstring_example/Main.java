package a471_join_joinstring_example;

import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        String animals = "dog,cat,bear";
        String[] arr = animals.split(",");
        System.out.println(useJoin(arr)); // dog+cat+bear
        System.out.println(userStringJoiner(arr)); // [dog-cat-bear]
    }

    private static String useJoin(String[] arr) {
        return String.join("+", arr);
    }

    private static String userStringJoiner(String[] arr) {
        // delimeter, prefix, suffix
        StringJoiner sj = new StringJoiner("-", "[", "]");
        for (String s : arr) {
            sj.add(s);
        }
        return sj.toString();
    }
}
