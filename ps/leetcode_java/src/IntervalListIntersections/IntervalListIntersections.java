package IntervalListIntersections;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int alen = A.length;
        int blen = B.length;
        int i=0, j=0;
        List<int[]> ret = new ArrayList<>();
        while(i<alen && j<blen){
            int a1 = A[i][0];
            int a2 = A[i][1];
            int b1 = B[j][0];
            int b2 = B[j][1];

            int left = Math.max(a1, b1);
            int right = Math.min(a2, b2);

            if(left<=right){
                int[] tmp = {left, right};
                ret.add(new int[]{left, right});
            }
            // 구간이 겹치는 인풋이 있을지도 몰라 이렇게 했으나 없는듯 하다.
            if(a2==b2){
                ++i;
                ++j;
            }
            else if(a2<b2){
                ++i;
            }
            else{
                ++j;
            }
        }
        // 작은 숫자를 넣으면 리스트 크기에 맞춰준다고 함
        return ret.toArray(new int[0][0]);
    }
    public static void main(String[] args) {
        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};
        IntervalListIntersections obj = new IntervalListIntersections();
        int[][] ret = obj.intervalIntersection(A,B);

        int len = ret.length;
        for(int i=0; i<len; ++i){
            System.out.println(ret[i][0] + "   " + ret[i][1]);
        }


    }
}
