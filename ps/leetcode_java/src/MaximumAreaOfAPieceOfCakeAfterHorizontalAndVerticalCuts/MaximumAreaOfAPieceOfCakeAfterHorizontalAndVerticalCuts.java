package MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {


    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        final int MOD = (int)1e9 + 7;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH = 0;
        int maxW = 0;
        int cur = 0;
        for(int i=0; i<horizontalCuts.length; ++i){
            maxH = Math.max(maxH, horizontalCuts[i] - cur);
            cur = horizontalCuts[i];
        }
        maxH = Math.max(maxH, h - cur);

        cur = 0;
        for(int i=0; i<verticalCuts.length; ++i){
            maxW = Math.max(maxW, verticalCuts[i] - cur);
            cur = verticalCuts[i];
        }
        maxW = Math.max(maxW, w - cur);
        long ret = (long)maxH * maxW;
        return (int)(ret%MOD);
    }

    public static void main(String[] args) {
        MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts sol = new MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts();
        int[] arr1 = {1,2,4};
        int[] arr2 = {1,3};
        sol.maxArea(5,4, arr1, arr2);
    }

}


