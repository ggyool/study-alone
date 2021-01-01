package NumberOfSubarraysWithBoundedMaximum;

public class NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int left = -1;
        int right = -1;
        int ret = 0;

        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            if (num > R) {
                left =  i;
                right = i;
            } else if (inRange(num, L, R)) {
                right = i;
                ret += (right - left);
            }
        }
        return ret;
    }

    boolean inRange(int num, int L, int R) {
        return L <= num && num <= R;
    }
}
