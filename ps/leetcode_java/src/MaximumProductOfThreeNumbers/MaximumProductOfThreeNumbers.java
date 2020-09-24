package MaximumProductOfThreeNumbers;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        int len = nums.length;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i=0; i<len; ++i){
            int num = nums[i];
            if(num>max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if(num>max2) {
                max3 = max2;
                max2 = num;
            }
            else if(num>max3) {
                max3 = num;
            }

            if(num<min1) {
                min2 = min1;
                min1 = num;
            }
            else if(num<min2) {
                min2 = num;
            }
        }
        int a = min1*min2*max1;
        int b = max1*max2*max3;
        return Math.max(a,b);
    }
}


