package SerializeAndDeserializeBinaryTree;

import apple.laf.JRSUIUtils;

public class SerializeAndDeserializeBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    String s;
    int idx;
    int len;

    public String dfs(TreeNode root){
        String ret = String.valueOf(root.val);
        if(root.left!=null){
            ret += "l" + dfs(root.left);
        }
        if(root.right!=null){
            ret +=  "r" + dfs(root.right);
        }
        ret += "o";
        return ret;
    }

    public String serialize(TreeNode root) {
        if(root==null) return "";
        return dfs(root);
    }

    public int splitVal(){
        String tmp = "";
        for(; idx<len; ++idx){
            char c = s.charAt(idx);
            if(Character.isLetter(c)) break;
            tmp += c;
        }
        return Integer.parseInt(tmp);
    }

    // 1l2or3l4or5ooo
    public TreeNode makeTree(){
        if(idx>=len) return null;
        TreeNode root = new TreeNode(splitVal());
        if(idx<len && s.charAt(idx)=='l'){
            ++idx;
            root.left = makeTree();
        }
        if(idx<len && s.charAt(idx)=='r'){
            ++idx;
            root.right = makeTree();
        }
        if(idx<len && s.charAt(idx)=='o'){
            ++idx;
        }
        return root;
    }

    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        this.s = data;
        this.idx = 0;
        this.len = s.length();
        return makeTree();
    }

}
