package 풍선터뜨리기;

import java.util.PriorityQueue;

// [-16,27,65,-2,58,-92,-71,-68,-61,-33]
public class Solution2 {
    // 가장 작은 수의 위치를 찾고,
    // 자신보다 작은 숫자가 왼쪽 or 오른쪽에 있다면 양쪽에 작은게 2개 있으므로
    // 카운팅하면 안 된다.
    public int solution(int[] a) {
        int alen = a.length;
        int idx = 0;
        int minv = Integer.MAX_VALUE;
        for(int i=0; i<a.length; ++i){
            if(a[i] < minv) {
                minv = a[i];
                idx = i;
            }
        }
        int ret = 1; // 가장 작은 수는 무조건 통과
        minv = Integer.MAX_VALUE;
        for(int i=0; i<5; ++i){
            if(a[i] < minv) {
                minv = a[i];
                ++ret;
            }
        }
        minv = Integer.MAX_VALUE;
        for(int i=alen-1; i>idx; --i){
            if(a[i] < minv) {
                minv = a[i];
                ++ret;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[] arr = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        System.out.println(sol.solution(arr));
    }
}
