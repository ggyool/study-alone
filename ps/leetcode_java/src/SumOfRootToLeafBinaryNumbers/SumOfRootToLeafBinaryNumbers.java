package SumOfRootToLeafBinaryNumbers;

import java.util.Objects;

public class SumOfRootToLeafBinaryNumbers {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode cur, int sum) {
        if (Objects.isNull(cur)) {
            return 0;
        }
        TreeNode left = cur.left;
        TreeNode right = cur.right;
        int currentValue = 2 * sum + cur.val;
        if (left == null && right == null) {
            return currentValue;
        }

        return dfs(left, currentValue) + dfs(right, currentValue);
    }
}


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
