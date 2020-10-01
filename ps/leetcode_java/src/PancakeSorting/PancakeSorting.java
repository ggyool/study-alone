package PancakeSorting;

import java.util.ArrayList;
import java.util.List;

// 여러 정답중 한개만 찾으면 되므로 뒤부터 한개씩 찾는다.
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> ret = new ArrayList<>();
        for(int v=n; v>=1; --v){
            for(int i=0; i<n; ++i){
                if(arr[i] == v){
                    reverseArr(i, arr);
                    ret.add(i+1);
                    // v 는 v-1 자리에 들어가야 한다.
                    reverseArr(v-1, arr);
                    ret.add(v);
                    break;
                }
            }
        }
        return ret;
    }

    private void reverseArr(int idx, int[] arr) {
        for(int i=0; i<=idx/2; ++i){
            int tmp = arr[i];
            arr[i] = arr[idx-i];
            arr[idx-i] = tmp;
        }
    }
}
