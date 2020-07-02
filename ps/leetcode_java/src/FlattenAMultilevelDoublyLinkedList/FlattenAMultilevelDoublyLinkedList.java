package FlattenAMultilevelDoublyLinkedList;

public class FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    // 처음 풀이
    public Node dfs(Node cur){
        Node nextNode = cur.next;
        if(cur.child != null){
            cur.next = cur.child;
            cur.child.prev = cur;
            Node res = dfs(cur.child);
            cur.child = null;
            if(nextNode!=null) res.next = nextNode;
            if(nextNode!=null) nextNode.prev = res;
        }
        if(nextNode == null){
            return cur;
        }
        else{
            return dfs(nextNode);
        }
    }
    public Node flatten(Node head) {
        if(head!=null) dfs(head);
        return head;
    }
}