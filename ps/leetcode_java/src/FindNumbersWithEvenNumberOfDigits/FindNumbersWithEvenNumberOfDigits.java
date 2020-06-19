package FindNumbersWithEvenNumberOfDigits;

public class FindNumbersWithEvenNumberOfDigits {
    static int count(int n){
        if(n==0) return 1;
        n = Math.abs(n);
        int ret = 0;
        while(n>0){
            n /= 10;
            ++ret;
        }
        return ret;
    }

    public int findNumbers(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            if(count(num)%2 == 0)
                ++ret;
        }
        return ret;
    }
}
