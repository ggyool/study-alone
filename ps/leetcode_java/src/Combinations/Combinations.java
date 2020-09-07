package Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    private void pick(int p, List<Integer> list, int n, int k, List<List<Integer>> ans){
        if(list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(p>n) return;
        list.add(p);
        pick(p+1, list, n, k, ans);
        list.remove(list.size()-1);

        pick(p+1, list, n, k, ans);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        pick(1, new ArrayList<Integer>(), n, k, ans);
        return ans;
    }

}

