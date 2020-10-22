package BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

// dfs 하는데 오른쪽 먼저 들리게 한다.
// 모든 노드 살펴보지 않아도 될 것 같지만, 왼쪽 트리쪽만 길다면? 다 돌아야 한다.
// N제한이 딱히 안나와있다.
// 처음 만들 때는 같은 높이를 또 방문하므로 배열 크기 잡고 visited 처럼 활용했는데, list.size()를 이용하면 리스트 만으로도 할 수 있다.
public class BinaryTreeRightSideView {


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, 0, ret);
        return ret;
    }

    private void dfs(TreeNode root, int h, List<Integer> list){
        if(root==null) return;
        // h로 처음 방문한 노드만 리스트에 들어간다.
        if(h>=list.size()){
            list.add(root.val);
        }
        dfs(root.right, h+1, list);
        dfs(root.left, h+1, list);
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