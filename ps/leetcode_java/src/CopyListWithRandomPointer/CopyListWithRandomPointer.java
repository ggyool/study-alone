package CopyListWithRandomPointer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CopyListWithRandomPointer {
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
    public void traverse(Node head){
        Node cur = head;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    // 서로 바라보게 만들기
    // node.next = newNode;
    // newNode.random = node;
    // node.next 를 기억하는 큐가 필요했다.
    public Node copyRandomList(Node head) {
        Node cur = head;
        Node dummy = new Node(-1);
        Node newCur = dummy;
        Queue<Node> q = new LinkedList<>();
        while(cur!=null){
            Node nextNode = cur.next;
            Node newNode = new Node(cur.val);
            newNode.random = cur;
            newCur.next = newNode;
            newCur = newNode;
            cur.next = newNode;
            cur = nextNode;
            q.add(nextNode);
        }
        newCur = dummy.next;
        while(newCur!=null){
            cur = newCur.random;
            if(cur.random==null)
                newCur.random = null;
            else
                newCur.random = cur.random.next;
            newCur = newCur.next;
        }
        cur = head;
        while(cur!=null){
            cur.next = q.peek();
            q.poll();
            cur = cur.next;
        }
        return dummy.next;
    }
}
