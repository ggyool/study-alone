package MaximumSwap_2;

public class MaximumSwap_2 {
    // 남의 코드
    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        // i가 나오는 인덱스 중 마지막
        int[] last = new int[10];

        for (int i=0; i<arr.length; ++i) {
            int n = arr[i] - '0';
            last[n] = i;
        }
        for(int i=0; i<arr.length; ++i){
            int n = arr[i] - '0';
            for(int j=9; j>n; --j){
                if(i<last[j]) {
                    char tmp = arr[i];
                    arr[i] = arr[last[j]];
                    arr[last[j]] = tmp;
                    return Integer.valueOf(new String(arr));
                }
            }
        }
        return num;
    }
}
