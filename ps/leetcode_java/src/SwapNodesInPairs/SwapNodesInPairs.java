package SwapNodesInPairs;


// 1->2->3->4
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next!=null && cur.next.next!=null){
            ListNode nextNode = cur.next.next.next;
            ListNode tmp = cur.next.next; // 2
            cur.next.next.next = cur.next; // 2->1
            cur.next.next = nextNode; // 1->3
            cur.next = tmp; // dummy->2
            cur = cur.next.next;
        }
        return dummy.next;
    }
}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}