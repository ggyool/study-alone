package ReverseLinkedList;

public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        ListNode befNode = null;
        ListNode nextNode = null;
        ListNode curNode = head;
        while(curNode!=null){
            nextNode = curNode.next;
            curNode.next = befNode;
            befNode = curNode;
            curNode = nextNode;
        }
        return befNode;
    }
}
