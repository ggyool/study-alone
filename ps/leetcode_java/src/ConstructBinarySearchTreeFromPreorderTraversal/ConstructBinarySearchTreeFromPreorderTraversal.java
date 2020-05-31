package ConstructBinarySearchTreeFromPreorderTraversal;

import apple.laf.JRSUIUtils;

public class ConstructBinarySearchTreeFromPreorderTraversal {
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
    public TreeNode bstFromPreorder(int[] preorder) {
        return makeTree(0, preorder.length-1, preorder);
    }

    public TreeNode makeTree(int left, int right, int[] preorder){
        if(left>right) return null;
        TreeNode cur = new TreeNode(preorder[left]);
        int i;
        for(i=left+1; i<=right; ++i){
            if(preorder[i] > cur.val){
                break;
            }
        }
        cur.left = makeTree(left+1, i-1, preorder);
        cur.right = makeTree(i, right, preorder);
        return cur;
    }



}
