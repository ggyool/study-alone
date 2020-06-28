package RemoveNthNodeFromEndOfList;

public class RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 처음 - dummy 없이
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode fastCur = head;
//        ListNode slowCur = head;
//        for(int i=0; i<n; ++i){
//            fastCur = fastCur.next;
//        }
//        // fastCur == null 이면 가장 처음 원소를 지워야 하는 경우
//        while(fastCur!=null && fastCur.next!=null){
//            fastCur = fastCur.next;
//            slowCur = slowCur.next;
//        }
//        if(fastCur==null){
//            head = slowCur.next;
//            slowCur = null;
//        }
//        else{
//            slowCur.next = slowCur.next.next;
//            slowCur = slowCur.next;
//            slowCur = null;
//        }
//        return head;
//    }

    // solution - with dummy
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fastCur = dummy;
        ListNode slowCur = dummy;
        for(int i=0; i<n; ++i){
            fastCur = fastCur.next;
        }
        while(fastCur.next!=null){
            fastCur = fastCur.next;
            slowCur = slowCur.next;
        }
        slowCur.next = slowCur.next.next;
        slowCur = slowCur.next;
        slowCur = null;
        return dummy.next;
    }
}
