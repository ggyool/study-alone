package CountingBits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingBits {
    public int[] countBits(int num) {
        int[] arr = new int[num+1];
        int exp = 0;
        for(int i=1; i<=num; ++i){
            if( (1<<exp) == i){
                arr[i] = 1;
                ++exp;
            }
            else{
                // i 가 3일 때 exp는 2 bef 2
                int bef = 1<<(exp-1);
                arr[i] = arr[bef] + arr[i-bef];
            }
        }
        return arr;
    }

}

/*
예시 코드 - 어떻게 생각헀을까 하는 깔끔한 코드
public int[] countBits(int num) {
        int[] arr=new int[num+1];
	    for(int x=1;x<=num;x++) {
            int y=(x&(x-1));
            arr[x]=arr[y]+1;
		}
	    return arr;
    }
 */