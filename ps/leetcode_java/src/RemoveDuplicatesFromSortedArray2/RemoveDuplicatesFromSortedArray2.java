package RemoveDuplicatesFromSortedArray2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
                numList.add(num);
            }
        }
        int i = 0;
        for (int num : numList) {
            if (count.get(num) == 1) {
                nums[i++] = num;
            } else {
                nums[i++] = num;
                nums[i++] = num;
            }
        }
        return i;
    }
}
