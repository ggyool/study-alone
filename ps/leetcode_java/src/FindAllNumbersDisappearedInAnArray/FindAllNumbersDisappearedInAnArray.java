package FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    // 처음 풀이
    public List<Integer> findDisappearedNumbers_first(int[] arr) {
        int len = arr.length;
        int i = 0;
        while(i<len){
            int num = arr[i];
            if(num-1 != i && arr[num-1]!=num){
                int tmp = arr[i];
                arr[i] = arr[num-1];
                arr[num-1] = tmp;
            }
            else{
                ++i;
            }
        }
        List<Integer> ret = new ArrayList<>();
        for(i=0; i<len; ++i){
            if(arr[i] != i+1){
                ret.add(i+1);
            }
        }
        return ret;
    }

    // 존재 하는 숫자에 -체크를 한다.
    public List<Integer> findDisappearedNumbers(int[] arr) {
        int len = arr.length;
        for(int i=0; i<len; ++i){
            int idx = Math.abs(arr[i]) - 1;
            if(arr[idx]>0) arr[idx] *= -1;
        }
        List<Integer> ret = new ArrayList<>();
        for(int i=0; i<len; ++i){
            if(arr[i] > 0) ret.add(i+1);
        }
        return ret;
    }

    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }
}



/*
{4,3,2,7,8,2,3,1}
{4,3,2,-7,8,2,3,1}
{4,3,-2,-7,8,2,3,1}
{4,-3,-2,-7,8,2,3,1}
{4,-3,-2,-7,8,2,3,-1}
{-4,-3,-2,-7,8,2,-3,-1}

for(int i = 0; i < nums.length; i++) {
    int val = Math.abs(nums[i]) - 1;
    if(nums[val] > 0) {
        nums[val] = -nums[val];
    }
}

for(int i = 0; i < nums.length; i++) {
    if(nums[i] > 0) {
        ret.add(i+1);
    }
}
return ret;



 */


