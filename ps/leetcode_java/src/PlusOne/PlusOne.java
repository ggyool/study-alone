package PlusOne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> nums = new ArrayList<>();
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + plus == 10) {
                nums.add(0);
                plus = 1;
            } else {
                digits[i] += plus;
                plus = 0;
                nums.add(digits[i]);
            }
        }
        if (plus == 1) {
            nums.add(1);
        }
        int[] ret = new int[digits.length + 1];
        Collections.reverse(nums);
        return nums.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
