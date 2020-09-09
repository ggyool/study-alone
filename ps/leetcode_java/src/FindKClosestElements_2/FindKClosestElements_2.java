package FindKClosestElements_2;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements_2 {

    int subAbs(int[] arr, int idx, int x){
        int ret = arr[idx] - x;
        if(ret<0) return -ret;
        return ret;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0;
        int j = arr.length-1;
        while(j-i+1>k){
            if(subAbs(arr,i,x)<=subAbs(arr,j,x)){
                --j;
            }
            else{
                ++i;
            }
        }
        List<Integer> ret = new ArrayList<>();
        for(int idx=i; idx<=j; ++idx){
            ret.add(arr[idx]);
        }
        return ret;
    }
}
