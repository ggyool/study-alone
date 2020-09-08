package Permutations_2;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations_2 {

    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void solve(int l, int r, int[] nums, List<List<Integer>> ans){
        if(l==r){
            // ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            ans.add(tmp);
            return;
        }
        for(int i=l; i<=r; ++i){
            swap(l, i, nums);
            solve(l+1, r, nums, ans);
            swap(l, i, nums);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums.length-1, nums, ans);
        return ans;
    }
}
