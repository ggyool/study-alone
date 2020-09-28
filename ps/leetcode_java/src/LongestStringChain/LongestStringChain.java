package LongestStringChain;

import java.util.ArrayList;
import java.util.List;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        List<String>[] slist = new List[17];
        List<Integer>[] ilist = new List[17];
        for(int i=1; i<=16; ++i){
            slist[i] = new ArrayList<>();
            ilist[i] = new ArrayList<>();
        }
        for(int i=0; i<words.length; ++i){
            int len = words[i].length();
            slist[len].add(words[i]);
            ilist[len].add(1);
        }
        int ans = 1;
        for(int i=2; i<=16; ++i){
            for(int j=0; j<slist[i].size(); ++j){
                String cur = slist[i].get(j);
                for(int k=1; k<i; ++k){
                    for(int l=0; l<slist[k].size(); ++l){
                        String target = slist[k].get(l);
                        if(isAble(cur, target)){
                            int maxv = Math.max(ilist[i].get(j), ilist[k].get(l)+1);
                            ilist[i].set(j, maxv);
                            ans = Math.max(ans, maxv);
                        }
                    }
                }
            }
        }
        return ans;
    }

    boolean isAble(String cur, String target){
        int j = 0;
        for(int i=0; i<cur.length(); ++i){
            if(j==target.length()) return true;
            if(cur.charAt(i) == target.charAt(j)){
                ++j;
            }
        }
        return j==target.length();
    }
}
