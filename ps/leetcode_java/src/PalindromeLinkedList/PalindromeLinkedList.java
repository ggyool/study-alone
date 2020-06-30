package PalindromeLinkedList;

public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

//    public boolean isPalindrome(ListNode head) {
//        if(head==null) return true;
//        ListNode fast = head;
//        ListNode slow = head;
//        ListNode tailDummy = new ListNode();
//        while(fast.next!=null){
//            if(fast.next.next!=null)
//                fast = fast.next.next;
//            else if(fast.next!=null){
//                fast = fast.next;
//            }
//            slow = slow.next;
//        }
//        fast.next = tailDummy;
//
//        // slow->fast reverse
//        ListNode cur = slow;
//        ListNode bef = null;
//        while(cur!=null){
//            ListNode nextNode = cur.next;
//            cur.next = bef;
//            bef = cur;
//            cur = nextNode;
//        }
//
//        ListNode leftCur = head;
//        ListNode rightCur = tailDummy.next;
//        while(rightCur!=null){
//            if(leftCur.val != rightCur.val) return false;
//            leftCur = leftCur.next;
//            rightCur = rightCur.next;
//        }
//        return true;
//    }

    // 잘 생각해보면 홀 짝 상관없다.
    // 1-2-3-2-1 (3-2-1 reverse)
    // left: 1-2-3...
    // right: null-3-2-1
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null){
            if(fast.next.next!=null)
                fast = fast.next.next;
            else if(fast.next!=null){
                fast = fast.next;
            }
            slow = slow.next;
        }
        // slow->fast reverse
        ListNode cur = slow;
        ListNode bef = null;
        while(cur!=null){
            ListNode nextNode = cur.next;
            cur.next = bef;
            bef = cur;
            cur = nextNode;
        }
        ListNode leftCur = head;
        ListNode rightCur = fast;
        while(rightCur!=null){
            if(leftCur.val != rightCur.val) return false;
            leftCur = leftCur.next;
            rightCur = rightCur.next;
        }
        return true;
    }

}
