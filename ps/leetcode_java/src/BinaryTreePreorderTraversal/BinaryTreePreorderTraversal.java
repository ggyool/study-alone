package BinaryTreePreorderTraversal;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {

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
    public void preorder(TreeNode cur, List<Integer> list){
        list.add(cur.val);
        if(cur.left!=null){
            preorder(cur.left, list);
        }
        if(cur.right!=null){
            preorder(cur.right, list);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return Collections.emptyList();
        List<Integer> list = new LinkedList<>();
        preorder(root, list);
        return list;
    }
}
