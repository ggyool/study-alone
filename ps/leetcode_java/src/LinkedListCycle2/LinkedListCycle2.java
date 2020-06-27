package LinkedListCycle2;

import java.util.HashSet;

public class LinkedListCycle2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        // floyd cycle detection
        public static ListNode detectCycle(ListNode head) {
            ListNode fastCur = head;
            ListNode slowCur = head;
            if(slowCur==null) return null;
            while(true){
                if(fastCur.next==null || fastCur.next.next==null) return null;
                fastCur = fastCur.next.next;
                slowCur = slowCur.next;
                if(fastCur==slowCur) break;
            }
            slowCur = head;
            while(slowCur!=fastCur){
                slowCur = slowCur.next;
                fastCur = fastCur.next;
            }
            return fastCur;
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(0);
            ListNode cur = head;
            ListNode cycleNode=null, tailNode=null;
            for(int i=1; i<=15; ++i){
                ListNode newNode = new ListNode(i);
                if(i==9) cycleNode = newNode;
                if(i==15) tailNode = newNode;
                cur.next = newNode;
                cur = newNode;
            }
            tailNode.next = cycleNode;
            ListNode resNode = detectCycle(head);
            System.out.println(resNode.val);
        }
    }
}
