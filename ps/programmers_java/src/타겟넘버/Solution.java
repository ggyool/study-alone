package 타겟넘버;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int[] numbers, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        for(int i=0; i<numbers.length; ++i){
            int num = numbers[i];
            int qlen = q.size();
            for(int j=0; j<qlen; ++j){
                int popNum = q.poll();
                q.add(popNum - num);
                q.add(popNum + num);
            }
        }
        int answer = 0;
        while (!q.isEmpty()){
            int n = q.poll();
            if(n==target)
                ++answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,1,1,1,1};
        System.out.println(sol.solution(arr, 3));
    }
}
