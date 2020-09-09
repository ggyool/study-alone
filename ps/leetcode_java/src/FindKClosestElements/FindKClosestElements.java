package FindKClosestElements;

import java.util.*;

public class FindKClosestElements {

    // 값이 없는데 중간값이면 바로 큰 값의 인덱스
    // 값이 없는데 배열의 값보다 큰 값이면 마지막 인덱스
    int lowerBound(int target, int[] arr){
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        while(left<right) {
            mid = left + (right - left) / 2;
            if (target <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    int subAbs(int[] arr, int idx, int x){
        int ret = arr[idx] - x;
        if(ret<0) return -ret;
        return ret;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stk = new Stack<>();
        int idx = lowerBound(x, arr);
        int i = idx-1;
        int j = idx;
        for(int t=0; t<k; ++t){
            if(i==-1 || (j!=arr.length && subAbs(arr,i,x) > subAbs(arr,j,x))){
                q.add(arr[j++]);
            }
            else {
                stk.push(arr[i--]);
            }
        }
        List<Integer> ret = new ArrayList<>();
        while(!stk.isEmpty()){
            ret.add(stk.pop());
        }
        while(!q.isEmpty()) {
            ret.add(q.poll());
        }
        return ret;
    }
}


