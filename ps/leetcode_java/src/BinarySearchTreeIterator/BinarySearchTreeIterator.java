package BinarySearchTreeIterator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeIterator {

}

class BSTIterator {
    Queue<Integer> q;
    public BSTIterator(TreeNode root) {
        q = new LinkedList<>();
        inOrder(root);
    }

    private void inOrder(TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            inOrder(root.left);
        }
        q.offer(root.val);
        if(root.right!=null){
            inOrder(root.right);
        }
    }
    public int next() {
        return q.poll();
    }
    public boolean hasNext() {
        return !q.isEmpty();
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