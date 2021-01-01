package NumberOfSubarraysWithBoundedMaximum_2;

public class NumberOfSubarraysWithBoundedMaximum_2 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L-1);
    }

    private int count(int[] A, int val) {
        int ret = 0;
        int cnt = 0;
        // 2 2 1 2 3 4
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= val) {
                cnt++;
            } else {
                cnt = 0;
            }
            ret += cnt;
        }
        return ret;
    }
}
