package SymmetricTree;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
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

    // solution 을 봤다. symLeft 는 반 짤랐을 때 왼쪽 영역에 있는 노드
    public boolean isMirror(TreeNode symLeft, TreeNode symRight){
        if(symLeft==null && symRight==null) return true;
        if(symLeft==null || symRight==null) return false;
        return (symLeft.val==symRight.val) &&isMirror(symLeft.left, symRight.right) && isMirror(symLeft.right, symRight.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    // non recursive solution
    // 2개씩 짝 지어서 실행된다.
    public boolean isSymmetric_2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);

        while(!q.isEmpty()){
            TreeNode symLeft = q.poll();
            TreeNode symRight = q.poll();
            if(symLeft==null && symRight==null) continue;
            if(symLeft==null || symRight==null) return false;
            if(symLeft.val!=symRight.val) return false;
            q.add(symLeft.left);
            q.add(symRight.right);
            q.add(symLeft.right);
            q.add(symRight.left);
        }
        return true;
    }

}
