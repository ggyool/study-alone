package PathSum;

public class PathSum {
    public class TreeNode {
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
    boolean dfs(TreeNode cur, int sum){
        if(cur.left==null && cur.right==null && sum-cur.val==0)
            return true;
        if(cur.left!=null){
            if(dfs(cur.left, sum-cur.val)) return true;
        }
        if(cur.right!=null){
            if(dfs(cur.right, sum-cur.val)) return true;
        }
        return false;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        return dfs(root, sum);
    }
}
