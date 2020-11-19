package DeleteNodeInABST;

// geeksforgeeks.org/binary-search-tree-set-2-delete/
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key){
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;

            // left right 둘 다 있는 경우
            root.val = findMinValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        else if(key<root.val){
            root.left = deleteNode(root.left, key);
        }
        else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    int findMinValue(TreeNode root){
        int ret = root.val;
        while(root.left!=null){
            root = root.left;
            ret = root.val;
        }
        return ret;
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