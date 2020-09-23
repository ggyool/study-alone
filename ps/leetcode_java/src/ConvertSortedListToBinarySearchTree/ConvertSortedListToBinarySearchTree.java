package ConvertSortedListToBinarySearchTree;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        TreeNode root = new TreeNode();
        ListNode midNode = getMid(head);
        root.val = midNode.val;
        ListNode nextNode = midNode.next;
        if(head!=midNode)
            root.left = sortedListToBST(head);
        root.right = sortedListToBST(nextNode);
        return root;
    }

    public ListNode getMid(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode befNode = null;
        ListNode slowCur = head;
        ListNode fastCur = head;
        while(fastCur!=null) {

            if(fastCur.next==null){
                fastCur = fastCur.next;
            }
            else {
                fastCur = fastCur.next.next;
            }
            if(fastCur!=null){
                befNode = slowCur;
                slowCur = slowCur.next;
            }
        }
        if(befNode!=null)
            befNode.next = null;
        return slowCur;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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