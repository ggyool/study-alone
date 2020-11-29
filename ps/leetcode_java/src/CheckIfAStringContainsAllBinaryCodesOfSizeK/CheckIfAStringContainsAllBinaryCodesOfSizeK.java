package CheckIfAStringContainsAllBinaryCodesOfSizeK;

import java.util.HashSet;
import java.util.Set;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    Set<String> st;

    public boolean hasAllCodes(String s, int k) {
        st = new HashSet<>();
        int slen = s.length();
        if (slen < k) {
            return false;
        }

        int i = 0;
        int j = k;
        while (j <= slen) {
            String subs = s.substring(i, j);
            st.add(subs);
            i++;
            j++;
        }
        return st.size() == 1 << k;
//        return pick(0, k, new StringBuilder());
    }


    private boolean pick(int idx, int k, StringBuilder sb) {
        if (idx == k) {
            return st.contains(sb.toString());
        }


        sb.append('0');
        boolean ret1 = pick(idx+1, k, sb);
        if (!ret1) return false;
        sb.deleteCharAt(idx);

        sb.append('1');
        boolean ret2 = pick(idx+1, k, sb);
        if (!ret2) return false;
        sb.deleteCharAt(idx);

        return ret1 && ret2;
    }

    public static void main(String[] args) {
        CheckIfAStringContainsAllBinaryCodesOfSizeK sol = new CheckIfAStringContainsAllBinaryCodesOfSizeK();
        System.out.println(sol.hasAllCodes("01100", 2));
    }
}
