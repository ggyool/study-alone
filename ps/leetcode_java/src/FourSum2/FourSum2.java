package FourSum2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FourSum2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        List<Integer> list1 = new ArrayList<>();
        int la = A.length;
        int lb = B.length;
        for(int i=0; i<la; ++i){
            for(int j=0; j<lb; ++j){
                list1.add(A[i] + B[j]);
            }
        }
        List<Integer> list2 = new ArrayList<>();
        int lc = C.length;
        int ld = D.length;
        for(int i=0; i<lc; ++i){
            for(int j=0; j<ld; ++j){
                list2.add(C[i]+D[j]);
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        int len1 = list1.size();
        int len2 = list2.size();
        int i = 0;
        int j = len2 - 1;
        int ret = 0;
        while(i<len1 && j>=0){
            int target = list1.get(i) + list2.get(j);
            if(target==0){
                int cnt1 = 1, cnt2 = 1;
                int tmp1 = list1.get(i);
                int tmp2 = list2.get(j);
                while(++i<len1 && tmp1==list1.get(i)) ++cnt1;
                while(--j>=0 && tmp2==list2.get(j)) ++cnt2;
                ret += (cnt1*cnt2);
            } else if (target < 0) {
                ++i;
            } else {
                --j;
            }
        }
        return ret;
    }

}
