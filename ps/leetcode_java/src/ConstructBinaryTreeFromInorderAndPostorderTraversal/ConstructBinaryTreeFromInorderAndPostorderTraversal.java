package ConstructBinaryTreeFromInorderAndPostorderTraversal;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode makeTree(int[] inorder, int[] postorder, int il, int ir, int pl, int pr, HashMap<Integer, Integer> mp){
        if(il>ir || pl>pr) return null;
        int rootVal = postorder[pr];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = mp.get(rootVal);
        int leftCnt = rootIdx-il;
        root.left = makeTree(inorder, postorder, il, rootIdx-1, pl, pl+leftCnt-1, mp);
        root.right = makeTree(inorder, postorder, rootIdx+1, ir, pl+leftCnt, pr-1, mp);
        return root;
    }

    // post의 끝은 root, in에서 root를 찾아 left, right 찾기
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int len = inorder.length;
        for(int i=0; i<len; ++i){
            mp.put(inorder[i], i);
        }
        return makeTree(inorder, postorder, 0, len-1, 0, len-1, mp);
    }
}
