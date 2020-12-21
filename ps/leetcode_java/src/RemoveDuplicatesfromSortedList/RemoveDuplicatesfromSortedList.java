package RemoveDuplicatesfromSortedList;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> st = new HashSet<>();
        ListNode bef = null;
        ListNode cur = head;
        while (cur != null) {
            if (!st.contains(cur.val)) {
                st.add(cur.val);
                bef = cur;
            } else {
                bef.next = cur.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
