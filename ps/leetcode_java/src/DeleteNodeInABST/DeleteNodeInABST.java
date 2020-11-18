package DeleteNodeInABST;

public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = findNode(root, key);
        if(node==null) return root;
        // terminal 노드인 경우
        if(node.left==null && node.right==null) {
            if(root.val==key) return null;
            deleteClosestNode(root, node);
        }
        else if(node.right!=null){
            TreeNode closestNode = findClosestBigger(node.right, node.val);
            node.val = closestNode.val;
            deleteClosestNode(node, closestNode);
            closestNode = null;
        }
        else if(node.left!=null){
            TreeNode closestNode = findClosestSmaller(node.left, node.val);
            node.val = closestNode.val;
            deleteClosestNode(node, closestNode);
            closestNode = null;
        }
        return root;
    }


    // 지워야 하는 노드가 터미널 노드가 아닐 수도 있다.
    private void deleteClosestNode(TreeNode root, TreeNode target){
        if(target.val<root.val){
            if(root.left.val==target.val) {
                root.left = null;
                return;
            }
            deleteClosestNode(root.left, target);
        }
        else{
            if(root.right.val==target.val) {
                root.right = null;
                return;
            }
            deleteClosestNode(root.right, target);
        }
    }

    private TreeNode findNode(TreeNode root, int key){
        if(root==null) return null;
        if(root.val==key) return root;
        else if(key<root.val) return findNode(root.left, key);
        else return findNode(root.right, key);
    }

    // left 타고 들어가기
    private TreeNode findClosestBigger(TreeNode root, int val){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }

    private TreeNode findClosestSmaller(TreeNode root, int val) {
        while(root.right!=null){
            root = root.right;
        }
        return root;
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