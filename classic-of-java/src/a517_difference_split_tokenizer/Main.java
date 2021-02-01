package a517_difference_split_tokenizer;

import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) {
        String s = "100,,,200,300";
        String[] arr = s.split(",");
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
        System.out.println("------------------------------------");
        StringTokenizer st = new StringTokenizer(s, ",");
        System.out.println(st.countTokens());
        while (st.hasMoreTokens()) {
            System.out.print(st.nextToken() + "|");
        }
    }
}
