package InsertIntoABinarySearchTree;

public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        insertNode(root, val);
        return root;
    }

    private void insertNode(TreeNode root, int val){
        if(val<root.val){
            if(root.left==null) root.left = new TreeNode(val);
            else insertNode(root.left, val);
        }
        else{
            if(root.right==null) root.right = new TreeNode(val);
            else insertNode(root.right, val);
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