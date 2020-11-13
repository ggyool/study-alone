package 구명보트;

import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int i = 0;
        int j = people.length-1;
        while(i<=j){
            if(i==j) {
                ++answer;
                break;
            }
            if(people[i]+people[j]<=limit){
                ++answer;
                ++i;
                --j;
            }
            else{
                --j;
            }
        }
        return answer;
    }
}
