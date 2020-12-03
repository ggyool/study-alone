package Subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> ret;

    public List<List<Integer>> subsets(int[] nums) {
        ret = new ArrayList<>();
        pick(0, nums, new ArrayList<>());
        return ret;
    }

    private void pick(int idx, int[] nums, List<Integer> subset) {
        if (idx == nums.length) {
            ret.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        pick(idx + 1, nums, subset);
        subset.remove(subset.size() - 1);

        pick(idx + 1, nums, subset);
    }
}
