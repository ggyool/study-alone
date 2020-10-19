package MaximumSwap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 첫 자리 부터 확인한다.
// 뒤의 숫자중에 자신보다 큰 숫자 중 가장 큰 수
// 만약 큰 숫자가 여러개이면 뒤에있는 숫자 선택
public class MaximumSwap {
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        while(num>0){
            list.add(num%10);
            num /= 10;
        }
        Collections.reverse(list);

        int len = list.size();
        for(int i=0; i<len-1; ++i){
            int maxV = list.get(i)+1;
            int idx = -1;
            for(int j=i+1; j<len; ++j){
                if(list.get(j)>=maxV){
                    maxV = list.get(j);
                    idx = j;
                }
            }
            if(idx!=-1){
                int tmp = list.get(i);
                list.set(i, list.get(idx));
                list.set(idx, tmp);
                break;
            }
        }
        int ret = 0;
        for(int i=0; i<len; ++i){
            ret *= 10;
            ret += list.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        MaximumSwap sol = new MaximumSwap();

        System.out.println(sol.maximumSwap(9973));
    }

}
