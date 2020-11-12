package 조이스틱;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(String name) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<name.length(); ++i){
            char c = name.charAt(i);
            sum += Math.min(c-'A', 26 - (c-'A'));
            if(c!='A')
                list.add(i);
        }
        if(list.size()==0) return sum;
        if(list.size()==1){
            return sum + Math.min(list.get(0), name.length()-list.get(0));
        }
        // cnt>=2 인 경우
        // abbaaaaaba
        int plus = Integer.MAX_VALUE;
        int len = list.size();
        for(int i=0; i<len; ++i){
            int curIdx = list.get(i);
            int leftIdx = i==0 ? list.get(len-1) : list.get(i-1);
            int dist = 0;
            if(i==0)
                dist = leftIdx - curIdx;
            else
                dist = name.length() - curIdx + leftIdx;

            // 처음 시작 위치에 따른 거리 + 이동 거리 (dist)
            int startDist = Math.min(Math.min(curIdx, name.length()-curIdx), Math.min(leftIdx, name.length()-leftIdx));
            plus = Math.min(plus, startDist + dist);
        }
        sum += plus;
        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("AZAAZ")); // 5
    }
}
