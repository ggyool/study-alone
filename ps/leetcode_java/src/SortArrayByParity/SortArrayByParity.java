package SortArrayByParity;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] arr) {
        // 앞에서 부터 하면 똑같은 홀수가 계속 바뀔수 있으니
        // 뒤에서 부터 봤음
        int len = arr.length;
        int i = 0;
        int j = len-1;
        while(i<j){
            if(arr[i]%2==0) ++i;
            else if(arr[j]%2==1) --j;
            else {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
