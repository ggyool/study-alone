package DuplicateZeros;

import java.util.Arrays;

public class DuplicateZeros {
    // 안해봤지만, 공간 안쓰려면 0은 카운트2, 나머지는 카운트1로 어디까지 마지막 숫자 알아내고, 뒤부터 넣으면 될듯
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int[] trr = Arrays.copyOf(arr, len);
        int j = 0;
        for(int i=0; i<len; ++i){
            if(j==len) break;
            if(trr[i] == 0){
                arr[j++] = 0;
                if(j<len) arr[j++] = 0;
            }
            else{
                arr[j++] = trr[i];
            }
        }
    }
}
