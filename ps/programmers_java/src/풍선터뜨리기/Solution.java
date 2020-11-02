package 풍선터뜨리기;

// [-16,27,65,-2,58,-92,-71,-68,-61,-33]
public class Solution {
    public int solution(int[] a) {
        int alen = a.length;
        if(alen<=2) return alen;
        int[] lMin = new int[alen];
        int[] rMin = new int[alen];

        lMin[0] = a[0];
        rMin[alen-1] = a[alen-1];
        for(int i=1; i<alen; ++i){
            lMin[i] = Math.min(lMin[i-1], a[i]);
            int j = alen-1-i;
            rMin[j] = Math.min(rMin[j+1], a[j]);
        }
        int ret = 2;
        for(int i=1; i<alen-1; ++i) {
            int val = a[i];
            boolean leftCon = lMin[i-1]>val;
            boolean rightCon = rMin[i+1]>val;
            if(leftCon || rightCon) {
                ++ret;
            }
        }
        return ret;
    }

}

