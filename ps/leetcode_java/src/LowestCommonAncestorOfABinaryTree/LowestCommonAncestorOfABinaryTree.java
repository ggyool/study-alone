package LowestCommonAncestorOfABinaryTree;

import java.util.HashMap;

// 느리고 편한 방법으로 풀어보았음
public class LowestCommonAncestorOfABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    HashMap<TreeNode, TreeNode> parent;
    HashMap<TreeNode, Integer> height;
    void dfs(TreeNode cur, int h){
        if(cur.left!=null){
            parent.put(cur.left, cur);
            height.put(cur.left, h);
            dfs(cur.left, h+1);
        }
        if(cur.right!=null){
            parent.put(cur.right, cur);
            height.put(cur.right, h);
            dfs(cur.right, h+1);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        parent = new HashMap<>();
        height = new HashMap<>();
        height.put(root, 0);
        dfs(root, 1);
        int ph = height.get(p);
        int qh = height.get(q);
        int sh = Math.abs(ph-qh);

        for(int i=0; i<sh; ++i){
            if(ph>qh)
                p = parent.get(p);
            else
                q = parent.get(q);
        }

        while(p!=q){
            p = parent.get(p);
            q = parent.get(q);
        }
        return p;
    }
}
