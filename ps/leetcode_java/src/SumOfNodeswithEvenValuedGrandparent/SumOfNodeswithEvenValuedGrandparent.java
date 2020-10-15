package SumOfNodeswithEvenValuedGrandparent;

import java.util.HashMap;

public class SumOfNodeswithEvenValuedGrandparent {

    HashMap<TreeNode, TreeNode> parent;

    private void findParent(TreeNode root){
        if(root.left!=null) {
            parent.put(root.left, root);
            findParent(root.left);
        }
        if(root.right!=null) {
            parent.put(root.right, root);
            findParent(root.right);
        }
    }

    private int dfs(TreeNode root){
        int ret = 0;
        if(hasEvenValuedGrandParent(root)) ret += root.val;
        if(root.left!=null) ret += dfs(root.left);
        if(root.right!=null) ret += dfs(root.right);
        return ret;
    }

    private boolean hasEvenValuedGrandParent(TreeNode root){
        if(!parent.containsKey(root)) return false;
        TreeNode p = parent.get(root);
        if(!parent.containsKey(p)) return false;
        TreeNode gp = parent.get(p);
        return gp.val%2==0;
    }

    public int sumEvenGrandparent(TreeNode root) {
        parent = new HashMap<TreeNode, TreeNode>();
        findParent(root);
        return dfs(root);
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
