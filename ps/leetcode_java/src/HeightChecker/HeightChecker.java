package HeightChecker;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class HeightChecker {
    public int heightChecker(int[] arr) {
        int n = arr.length;
        int[] trr = Arrays.copyOf(arr, n);
        Arrays.sort(trr);
        int ret = 0;
        for(int i=0; i<n; ++i){
            if(arr[i] != trr[i]) ++ret;
        }
        return ret;
    }
}
