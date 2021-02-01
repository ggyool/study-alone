package a516_string_tokenizer_example2;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static Map<String, Long> bigUnits = new HashMap<>();
    private static Map<Character, Long> smallUnits = new HashMap<>();
    private static Map<Character, Long> numbers = new HashMap<>();

    static {
        smallUnits.put('십', 10L);
        smallUnits.put('백', 100L);
        smallUnits.put('천', 1000L);
        bigUnits.put("만", 10000L);
        bigUnits.put("억", (long) 1e8);
        bigUnits.put("조", (long) 1e12);

        numbers.put('일', 1L);
        numbers.put('이', 2L);
        numbers.put('삼', 3L);
        numbers.put('사', 4L);
        numbers.put('오', 5L);
        numbers.put('육', 6L);
        numbers.put('칠', 7L);
        numbers.put('팔', 8L);
        numbers.put('구', 9L);
    }

    public static void main(String[] args) {
        String input = "십조이천삼백억삼천칠백만삼천백십오";
        System.out.println(input);
        System.out.println(koreanToNumber(input));
    }

    private static long koreanToNumber(String korean) {
        long sum = 0L;
        long smallNumber = 0L;
        String bigUnitsDelimiter = "만억조";
        StringTokenizer st = new StringTokenizer(korean, bigUnitsDelimiter, true);
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (bigUnits.containsKey(s)) {
                if (smallNumber == 0L) {
                    sum += bigUnits.get(s);
                } else {
                    sum += smallNumber * bigUnits.get(s);
                    smallNumber = 0L;
                }
            } else {
                smallNumber = koreanToSmallNumber(s);
            }
        }
        return sum + smallNumber;
    }

    private static long koreanToSmallNumber(String korean) {
        long sum = 0L;
        long temp = 0L;
        for (char c : korean.toCharArray()) {
            if (smallUnits.containsKey(c)) {
                if (temp == 0L) {
                    sum += smallUnits.get(c);
                } else {
                    sum += temp * smallUnits.get(c);
                }
                temp = 0L;
            } else {
                temp += numbers.get(c);
            }
        }
        return sum +temp;
    }
}
