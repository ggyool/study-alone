package SerializeAndDeserializeBinaryTree2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void preOrder(TreeNode root, StringBuilder sb){
        if(root==null) {
            sb.append("null ");
            return;
        }
        sb.append(root.val + " ");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString().trim();
    }

    public TreeNode makeTree(LinkedList<String> list){
        String s = list.removeFirst();
        if(s.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = makeTree(list);
        node.right = makeTree(list);
        return node;
    }
    public TreeNode deserialize(String data) {
        String[] arr = data.split(" ");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(arr));
        return makeTree(list);
    }
}
