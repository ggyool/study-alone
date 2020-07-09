package ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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
    int[] preorder;
    int[] inorder;
    int len;
    HashMap<Integer, Integer> mp;
    public TreeNode makeTree(int il, int ir, int p){
        if(il>ir || p>=len) return null;
        int rootVal = preorder[p];
        int rootIdx = mp.get(rootVal);

        int leftCnt = rootIdx - il;
        int rightCnt = ir-rootIdx;
        TreeNode root = new TreeNode(rootVal);
        root.left = makeTree(il,rootIdx-1, p+1);
        root.right = makeTree(rootIdx+1, ir, p+leftCnt+1);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.len = inorder.length;
        mp = new HashMap<>();
        for(int i=0; i<len; ++i){
            mp.put(inorder[i], i);
        }
        return makeTree(0, len-1, 0);
    }
}
