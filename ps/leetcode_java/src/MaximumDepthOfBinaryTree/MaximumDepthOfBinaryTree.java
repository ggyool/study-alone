package MaximumDepthOfBinaryTree;

public class MaximumDepthOfBinaryTree {
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
    public int dfs(TreeNode cur){
        int ret = 0;
        if(cur.left != null){
            ret = dfs(cur.left) + 1;
        }
        if(cur.right != null){
            ret = Math.max(ret, dfs(cur.right)+1);
        }
        return ret;
    }

    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return dfs(root) + 1;
    }
}
