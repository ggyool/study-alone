package OddEvenLinkedList;

public class OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
//    처음 풀이
//    public ListNode oddEvenList(ListNode head) {
//        if(head==null) return null;
//        int cnt = 0;
//        ListNode evenHead = null;
//        ListNode oddTail = null;
//        ListNode cur = head;
//        while(cur!=null) {
//            ListNode nextNode = cur.next;
//            if(nextNode!=null)
//                cur.next = nextNode.next;
//            if(cnt%2==0){
//                if(nextNode==null || nextNode.next==null){
//                    oddTail = cur;
//                }
//            }
//            else{
//                if(evenHead==null){
//                    evenHead = cur;
//                }
//            }
//            cur = nextNode;
//            ++cnt;
//        }
//        oddTail.next = evenHead;
//        return head;
//    }
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        ListNode cur = head;
        ListNode odd=head, even=head.next;
        ListNode evenHead = even;
        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
