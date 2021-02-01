package a515_string_tokenizer_example;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        String s = "x=100*(200+300)/2";
        StringTokenizer st = new StringTokenizer(s, "+-*/=()", true);
        while (st.hasMoreTokens()) {
            System.out.print(st.nextToken() + "   ");
        }
    }
}
