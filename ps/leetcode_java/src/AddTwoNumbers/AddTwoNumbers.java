package AddTwoNumbers;

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        while(l1!=null || l2!=null){
            int v1 = l1==null ? 0 : l1.val;
            int v2 = l2==null ? 0 : l2.val;
            int val = (v1+v2+carry)%10;
            carry = (v1+v2+carry)/10;
            ListNode newNode = new ListNode(val);
            cur.next = newNode;
            cur = newNode;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(carry==1){
            ListNode newNode = new ListNode(1);
            cur.next = newNode;
        }
        return dummy.next;
    }
}
