package 전화번호목록;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    // 혹시 전화번호가 같은 케이스가 있을 수 있다면 따로 처리해야 할 듯
    public boolean solution(String[] phone_book) {
        HashSet<String> st = new HashSet<>();
        int minV = 21;

        for (String name : phone_book) {
            minV = Math.min(minV, name.length());
            st.add(name);
        }
        for (String name : phone_book) {
            int len = name.length();
            for(int i=minV; i<=len; ++i){
                String cut = name.substring(0, i);
                if(cut.equals(name)) continue;
                if(st.contains(cut)) return false;
            }
        }
        return true;
    }

    /* 남의 풀이 n**2 인데 더 빠르다.
    public boolean solution(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }
     */
}
