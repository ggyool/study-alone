package CustomSortString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomSortString {
    public String customSortString(String S, String T) {
        int[] seq = new int[26];
        for (int i = 0; i < 26; i++) {
            seq[i] = 27;
        }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            seq[c - 'a'] = i;
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < T.length(); i++) {
            list.add(T.charAt(i));
        }
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return seq[o1 - 'a'] - seq[o2 - 'a'];
            }
        });
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
