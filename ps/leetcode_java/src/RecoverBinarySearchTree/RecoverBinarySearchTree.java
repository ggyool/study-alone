package RecoverBinarySearchTree;

// 처음에는 min, max를 가지고 범위를 좁혀 나가며 값이 이상한 노드 찾았음
// 작은값이면 내려오며 봤던 값중에 큰 값이랑 바꿈

// 3,1,4,n,n,2 이면 2와 3을 바꿨다는 말
// 하지만 2,3,1 같은 경우 3과 1을 바꿔야 한다.

// 3,n,2,n,1 도 있다...

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> mistakeNodes = findMistakeNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        // System.out.println(mistakeNodes.size());
        // System.out.println(mistakeNodes.get(0).val);
        // System.out.println(mistakeNodes.get(1).val);
        if (mistakeNodes.size() == 2) {
            TreeNode nodeA = mistakeNodes.get(0);
            TreeNode nodeB = mistakeNodes.get(1);

            // 한쪽에 2개가 몰려 있는 경우
            if (nodeA.val > root.val && nodeB.val > root.val) {
                if (nodeA.val > nodeB.val) {
                    swap(root, nodeA);
                } else {
                    swap(root, nodeB);
                }
            } else if (nodeA.val < root.val && nodeB.val < root.val) {
                if (nodeA.val < nodeB.val) {
                    swap(root, nodeA);
                } else {
                    swap(root, nodeB);
                }
            } else {
                swap(nodeA, nodeB);
            }
            return;
        }
        swap(root, mistakeNodes.get(0));
    }

    private List<TreeNode> findMistakeNode(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        System.out.println(root.val + " " + minValue + " " + maxValue);

        List<TreeNode> ret = new ArrayList<TreeNode>();

        if (!inClosedRange(root, minValue, maxValue)) {
            ret.add(root);
        }

        ret.addAll(findMistakeNode(root.left, minValue, Math.min(maxValue, root.val - 1)));
        System.out.println(root.val + " " + minValue + " " + maxValue);
        ret.addAll(findMistakeNode(root.right, Math.max(minValue, root.val + 1), maxValue));

        return ret;
    }

    private boolean inClosedRange(TreeNode root, int minValue, int maxValue) {
        return minValue <= root.val && root.val <= maxValue;
    }

    private void swap(TreeNode nodeA, TreeNode nodeB) {
        int tmp = nodeA.val;
        nodeA.val = nodeB.val;
        nodeB.val = tmp;
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



