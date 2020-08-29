package ValidateBinarySearchTree;

public class ValidateBinarySearchTree {
    private boolean recur(TreeNode root, int left, int right){
        if(root.val<left || root.val>right) return false;
        boolean ret = true;
        if(root.left!=null){
            if(root.val==Integer.MIN_VALUE) return false;
            ret &= recur(root.left, left, root.val-1);
        }
        if(root.right!=null){
            if(root.val==Integer.MAX_VALUE) return false;
            ret &= recur(root.right, root.val+1, right);
        }
        return ret;
    }

    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return recur(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
