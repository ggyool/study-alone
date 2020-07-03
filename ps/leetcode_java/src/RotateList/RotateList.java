package RotateList;

public class RotateList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return null;
        int len = 1;
        ListNode cur = head;
        while(cur.next!=null){
            cur = cur.next;
            ++len;
        }
        cur.next = head;

        ListNode ret = null;
        ListNode bef = cur; // tail
        cur = head;
        k = (len-k%len);
        for(int i=0; i<k; ++i){
            bef = cur;
            cur = cur.next;
        }
        bef.next = null;
        return cur;
    }
}
