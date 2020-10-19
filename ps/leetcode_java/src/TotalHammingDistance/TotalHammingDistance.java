package TotalHammingDistance;

public class TotalHammingDistance {
    // 1 카운팅하는 아이디어
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int ret = 0;
        // i: binary digit
        for(int i=0; i<=30; ++i){
            int one = 0;
            int zero = 0;
            for(int j=0; j<n; ++j){
                int tmp = nums[j] >> i;
                if((tmp&1)==1) ++one;
                else ++zero;
            }
            ret += (one*zero);
        }
        return ret;
    }

    public static void main(String[] args) {
        TotalHammingDistance sol = new TotalHammingDistance();
        int arr[] = {4,14,2};
        System.out.println(sol.totalHammingDistance(arr));
    }

}
