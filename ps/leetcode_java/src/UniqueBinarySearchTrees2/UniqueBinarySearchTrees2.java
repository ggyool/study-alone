package UniqueBinarySearchTrees2;

import java.util.ArrayList;
import java.util.List;

// solution 참고
public class UniqueBinarySearchTrees2 {
    public List<TreeNode> makeTree(int left, int right){
        List<TreeNode> ret = new ArrayList<TreeNode>();
        if(left>right){
            ret.add(null);
            return ret;
        }
        List<TreeNode> leftTrees;
        List<TreeNode> rightTrees;
        for(int i=left; i<=right; ++i) {
            leftTrees = makeTree(left, i - 1);
            rightTrees = makeTree(i + 1, right);
            for (int n = 0; n < leftTrees.size(); ++n) {
                for (int m = 0; m < rightTrees.size(); ++m) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTrees.get(n);
                    root.right = rightTrees.get(m);
                    ret.add(root);
                }
            }
        }
        return ret;
    }

    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return makeTree(1, n);
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