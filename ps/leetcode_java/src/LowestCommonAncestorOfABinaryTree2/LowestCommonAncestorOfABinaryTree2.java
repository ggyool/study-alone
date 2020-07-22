package LowestCommonAncestorOfABinaryTree2;

public class LowestCommonAncestorOfABinaryTree2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // 내려가며 찾기
    TreeNode ans;
    public int dfs(TreeNode cur, TreeNode p, TreeNode q){
        if(cur==null) return 0;
        int ret = 0;
        if(cur==p) ret += 1;
        if(cur==q) ret += 1;
        ret += dfs(cur.left, p, q);
        ret += dfs(cur.right, p, q);
        if(ret==2 && ans==null) ans = cur;
        return ret;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }
}
