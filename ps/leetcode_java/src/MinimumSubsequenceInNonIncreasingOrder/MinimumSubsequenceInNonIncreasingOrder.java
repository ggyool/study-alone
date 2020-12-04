package MinimumSubsequenceInNonIncreasingOrder;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumSubsequenceInNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        List<Integer> list = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int sum = Arrays.stream(nums).sum();
        int half = sum / 2;
        int tmp = 0;
        for (int num : list) {
            tmp += num;
            ret.add(num);
            if (half < tmp) {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        MinimumSubsequenceInNonIncreasingOrder sol = new MinimumSubsequenceInNonIncreasingOrder();
        int[] arr = {4, 4, 7, 6, 7};
        List<Integer> integers = sol.minSubsequence(arr);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
