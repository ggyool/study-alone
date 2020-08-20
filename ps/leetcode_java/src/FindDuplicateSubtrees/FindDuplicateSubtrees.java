package FindDuplicateSubtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// dfs하고 올라오면서 기록
public class FindDuplicateSubtrees {

    HashMap<String, Integer> mp;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        mp = new HashMap<String, Integer>();
        ans = new ArrayList<TreeNode>();
        dfs(root);
        return ans;
    }

    private String dfs(TreeNode cur){
        if(cur==null) return "n";
        String ret = cur.val + "," + dfs(cur.left) + "," + dfs(cur.right);
        int cnt = mp.getOrDefault(ret, 0);
        if(cnt==1) ans.add(cur);
        Integer num = mp.put(ret, cnt + 1);
        System.out.println(num);
        mp.computeIfAbsent()
        return ret;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}