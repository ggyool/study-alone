package RemoveLinkedListElements;

import ReverseLinkedList.ReverseLinkedList;

public class RemoveLinkedListElements {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while(cur!=null){
            if(cur.next!=null && cur.next.val==val){
                cur.next = cur.next.next;
            }
            else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
