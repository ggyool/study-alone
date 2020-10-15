package SumOfNodeswithEvenValuedGrandparent_2;

public class SumOfNodeswithEvenValuedGrandparent_2 {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, null, null);
    }

    private int dfs(TreeNode cur, TreeNode p, TreeNode gp) {
        if(cur==null) return 0;
        int ret = 0;
        if(gp!=null && gp.val%2==0) ret += cur.val;
        ret += dfs(cur.left, cur, p);
        ret += dfs(cur.right, cur, p);
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
