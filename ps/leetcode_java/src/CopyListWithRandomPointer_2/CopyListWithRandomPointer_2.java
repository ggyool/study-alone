package CopyListWithRandomPointer_2;

public class CopyListWithRandomPointer_2 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // make interweaved list
    // a->a'->b->b'->c->c'
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node cur = head;
        while(cur!=null){
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        // set random pointer
        cur = head;
        while(cur!=null){
            if(cur.random!=null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // set next pointer
        cur = head;
        Node ret = head.next;
        while(cur!=null){
            Node copyNode = cur.next;
            Node nextNode = copyNode.next;
            if(nextNode == null){
                cur.next = null;
                copyNode.next = null;
            }
            else{
                cur.next = nextNode;
                copyNode.next = nextNode.next;
            }
            cur = cur.next;
        }
        return ret;
    }
}
