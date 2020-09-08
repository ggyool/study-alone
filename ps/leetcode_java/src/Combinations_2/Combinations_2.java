package Combinations_2;

import java.util.ArrayList;
import java.util.List;

public class Combinations_2 {
    private void dfs(List<Integer> list, int start, int n, int k, List<List<Integer>> ans){
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }
        // 남은 개수 < 뽑아야 하는 개수
        if(n-start+1 < k-list.size()) return;
        for(int i=start; i<=n; ++i){
            list.add(i);
            dfs(list,i+1, n, k, ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(new ArrayList<Integer>(), 1, n, k, ans);
        return ans;
    }
}
