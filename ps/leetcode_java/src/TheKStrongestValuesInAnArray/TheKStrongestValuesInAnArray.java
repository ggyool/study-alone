package TheKStrongestValuesInAnArray;

import java.util.Arrays;

public class TheKStrongestValuesInAnArray {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int idx = (arr.length-1)/2;
        int median = arr[idx];

        int i = 0;
        int j = arr.length - 1;
        int l = 0;
        int[] ret = new int[k];

        while(k-->0){
            if(Math.abs(arr[i] - median) > Math.abs(arr[j] - median)){
                ret[l++] = arr[i++];
            }
            else{
                ret[l++] = arr[j--];
            }
        }
        return ret;
    }
}
