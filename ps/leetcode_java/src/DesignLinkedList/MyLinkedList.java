package DesignLinkedList;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node{
        Node next, prev;
        int val;
        Node(){}
        Node(int val){
            this.val = val;
        }
    }

    public MyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if(index>=length) return -1;
        Node cur = head.next;
        for(int i=0; i<index; ++i){
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        head.next.prev = newNode;
        newNode.next = head.next;
        newNode.prev = head;
        head.next = newNode;
        ++length;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        tail.prev.next = newNode;
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev = newNode;
        ++length;
    }

    public void addAtIndex(int index, int val) {
        if(index>length) return;
        if(index==length) {
            addAtTail(val);
            return;
        }
        Node newNode = new Node(val);
        Node cur = head.next;
        for(int i=0; i<index; ++i){
            cur = cur.next;
        }
        newNode.prev = cur.prev;
        newNode.next = cur;
        cur.prev.next = newNode;
        cur.prev = newNode;
        ++length;
    }

    public void deleteAtIndex(int index) {
        if(index>=length) return;
        Node cur = head.next;
        for(int i=0; i<index; ++i){
            cur = cur.next;
        }
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        cur = null;
        --length;
    }
}

