package SwapNodesInPairs_2;


import java.util.List;

// recursive
public class SwapNodesInPairs_2 {
    // 진입할 때 2번째 노드가 앞으로 온다. 그 노드를 return
    private ListNode recur(ListNode cur){
        if(cur==null) return null;
        if(cur.next==null) return cur;
        ListNode nextNode = recur(cur.next.next);
        ListNode retNode = cur.next;
        cur.next.next = cur; // 4->3
        cur.next = nextNode; // 3->null
        return retNode;
    }
    public ListNode swapPairs(ListNode head) {
        return recur(head);
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}