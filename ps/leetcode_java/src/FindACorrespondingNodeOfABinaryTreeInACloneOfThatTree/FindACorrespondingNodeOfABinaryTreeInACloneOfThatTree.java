package FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return find(original, cloned, target);
    }

    private TreeNode find(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null) {
            return null;
        }

        if (original.equals(target)) {
            return cloned;
        }

        TreeNode leftNode = find(original.left, cloned.left, target);
        TreeNode rightNode = find(original.right, cloned.right, target);

        if (leftNode != null) return leftNode;
        if (rightNode != null) return rightNode;
        return null;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}