package IsomorphicStrings;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        HashSet<Character> st = new HashSet<>();
        HashMap<Character, Character> mp = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (mp.containsKey(sc)) {
                if (mp.get(sc) != tc) return false;
            } else {
                if (st.contains(tc)) return false;
                mp.put(sc, tc);
                st.add(tc);
            }
        }
        return true;
    }
}
