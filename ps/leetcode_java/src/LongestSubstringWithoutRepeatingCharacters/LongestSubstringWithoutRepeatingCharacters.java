package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    // 소문자 이외의 문자도 들어온다.
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> st = new HashSet<>();
        int ret = 0;
        int len = s.length();
        // i개, j폐
        int i = -1;
        for(int j=0; j<len; ++j){
            char c = s.charAt(j);
            if(!st.contains(c)){
                ret = Math.max(ret, j-i);
                st.add(c);
            }
            else{
                while(s.charAt(++i)!=c){
                    st.remove(s.charAt(i));
                }
            }
        }
        return ret;
    }
}
