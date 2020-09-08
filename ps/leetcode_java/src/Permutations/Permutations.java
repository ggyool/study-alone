package Permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    private void solve(ArrayList<Integer> list, int len, boolean[] visited, int[] nums, List<List<Integer>> ans) {
        if(list.size() == len){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<len; ++i){
            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                solve(list, len, visited, nums, ans);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        List<List<Integer>> ans = new ArrayList<>();
        solve(new ArrayList<Integer>(), len, visited, nums, ans);
        return ans;
    }
}
