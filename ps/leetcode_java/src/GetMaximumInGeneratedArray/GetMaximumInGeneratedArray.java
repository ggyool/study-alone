package GetMaximumInGeneratedArray;

public class GetMaximumInGeneratedArray {
    public int getMaximumGenerated(int n) {
        int[] arr = new int[101];
        if (n <= 1) {
            return n;
        }
        arr[0] = 0;
        arr[1] = 1;
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            if (isEven(i)) {
                arr[i] = arr[i / 2];
            } else {
                arr[i] = arr[i / 2] + arr[i / 2 + 1];
            }
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }

    private boolean isEven(int n) {
        return n % 2 == 0;
    }
}
