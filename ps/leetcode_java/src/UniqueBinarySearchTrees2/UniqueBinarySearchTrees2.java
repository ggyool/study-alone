package UniqueBinarySearchTrees2;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {
    public TreeNode makeTree(int val, int left, int right){
        TreeNode root = new TreeNode(val);
        for(int i=left; i<val; ++i){
            root.left = makeTree(i, left, val-1);
        }

        for(int i=val+1; i<=right; ++i){
            root.right
        }

    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ret = new ArrayList<TreeNode>();
        for(int i=1; i<=n; ++i){
            makeTree(i, 1, n);
        }
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