package FourSum2_2;

import java.util.HashMap;

public class FourSum2_2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int a : A){
            for(int b : B){
                mp.put(a+b, mp.getOrDefault(a+b, 0) + 1);
            }
        }
        int ret = 0;
        for(int c : C){
            for(int d : D){
                ret += mp.getOrDefault(-(c+d), 0);
            }
        }
        return ret;
    }
}
