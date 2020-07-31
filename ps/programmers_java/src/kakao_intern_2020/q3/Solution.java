package kakao_intern_2020.q3;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public int[] solution(String[] gems) {
        int[] answer = {0,0};
        HashSet<String> st = new HashSet<>();
        HashMap<String, Integer> mp = new HashMap();
        for (String gem : gems) {
            st.add(gem);
        }
        int typeCnt = st.size();
        int len = gems.length;
        int i = 0;
        int j = 0;
        int cnt = len + 1;
        while(i<len || j<len){
            if(j<len && mp.size() < typeCnt){
                String target = gems[j++];
                if(mp.containsKey(target)){
                    mp.replace(target, mp.get(target) + 1);
                }
                else{
                    mp.put(target, 1);
                }
            }
            else if(mp.size()==typeCnt){
                if(cnt>j-i){
                    cnt = j-i;
                    answer[0] = i;
                    answer[1] = j-1;
                }
                String target = gems[i++];
                if(mp.get(target) == 1){
                    mp.remove(target);
                }
                else{
                    mp.replace(target, mp.get(target) - 1);
                }
            }
            else{
                ++i;
            }
        }
        answer[0]++;
        answer[1]++;
        return answer;
    }
}
