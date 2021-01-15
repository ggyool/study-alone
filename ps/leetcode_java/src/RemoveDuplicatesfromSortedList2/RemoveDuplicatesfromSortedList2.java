package RemoveDuplicatesfromSortedList2;

public class RemoveDuplicatesfromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        ListNode bef = dummy;

        while (cur != null) {
            int val = cur.val;
            if (cur.next != null && cur.next.val == val) {
                while (cur != null && cur.val == val) {
                    bef.next = cur.next;
                    cur = cur.next;
                }
            } else {
                bef = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
