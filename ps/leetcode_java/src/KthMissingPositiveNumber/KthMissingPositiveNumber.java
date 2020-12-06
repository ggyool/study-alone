package KthMissingPositiveNumber;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int bef = 0;
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int diff = num - bef - 1;
            if (k - diff > 0) {
                k -= diff;
                bef = num;
            } else {
                ans = bef + k;
                break;
            }
        }
        if (ans == -1) {
            ans = bef + k;
        }
        return ans;
    }
}
