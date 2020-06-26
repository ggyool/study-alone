package LinkedListCycle;

import java.util.HashSet;
import java.util.List;

public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode fastCur = head.next;
        ListNode slowCur = head;
        while(fastCur!=slowCur){
            if(fastCur==null || fastCur.next==null) return false;
            slowCur = slowCur.next;
            fastCur = fastCur.next.next;
        }
        return true;
    }
}

/*
public boolean hasCycle(ListNode head) {
    HashSet<ListNode> st = new HashSet<>();
    ListNode cur = head;
    while(cur!=null){
        if(st.contains(cur)) return true;
        st.add(cur);
        cur = cur.next;
    }
    return false;
}
 */