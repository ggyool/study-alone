package FlattenAMultilevelDoublyLinkedList_2;

public class FlattenAMultilevelDoublyLinkedList_2 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    // solution
    public Node dfs(Node bef, Node cur){
        if(cur==null) return bef;
        bef.next = cur;
        cur.prev = bef;
        Node nextNode = cur.next;
        Node tail = dfs(cur, cur.child);
        cur.child = null;
        return dfs(tail, nextNode);
    }
    public Node flatten(Node head) {
        if(head==null) return null;
        Node dummy = new Node();
        dummy.next = head;
        dfs(dummy, head);
        head.prev = null;
        return dummy.next;
    }
}
