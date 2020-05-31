package ConstructBinarySearchTreeFromPreorderTraversalSolution_2;

public class ConstructBinarySearchTreeFromPreorderTraversalSolution_2 {

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

//    public TreeNode bstFromPreorder(int[] preorder) {
//        TreeNode root = new TreeNode(preorder[0]);
//        makeTree(1, root, preorder, (int)1e8+1);
//        return root;
//    }
//    public int makeTree(int idx, TreeNode cur, int[] preorder, int constraint){
//        if(idx<preorder.length && preorder[idx] < cur.val){
//            TreeNode newNode = new TreeNode(preorder[idx]);
//            cur.left = newNode;
//            idx = makeTree(idx+1, newNode, preorder, cur.val);
//        }
//        if(idx<preorder.length && preorder[idx] > cur.val && preorder[idx]<constraint){
//            TreeNode newNode = new TreeNode(preorder[idx]);
//            cur.right = newNode;
//            idx = makeTree(idx+1, newNode, preorder, constraint);
//        }
//        return idx;
//    }
    //  같은 아이디어 모범 풀이
    public TreeNode bstFromPreorder(int[] preorder){
        // reference 넘기기 위해 배열 사용..
        return makeTree(new int[]{0}, preorder, Integer.MAX_VALUE);
    }
    public TreeNode makeTree(int[] cursor, int[] preorder, int constraint){
        int idx = cursor[0];
        if(idx==preorder.length || constraint<preorder[idx]) return null;
        TreeNode root = new TreeNode(preorder[idx]);
        cursor[0]++;
        root.left = makeTree(cursor, preorder, root.val);
        root.right = makeTree(cursor, preorder, constraint);
        return root;
    }

}
