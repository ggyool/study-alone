package IntersectionOfTwoLinkedLists;

public class IntersectionOfTwoLinkedLists {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // 내 처음 풀이 길이를 구하고, 긴 리스트쪽에서 긴 만큼 전진시켜서 시작
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        int lenA = 0;
//        int lenB = 0;
//        ListNode curA = headA;
//        ListNode curB = headB;
//        while(curA!=null || curB!=null){
//            if(curA!=null){
//                curA = curA.next;
//                ++lenA;
//            }
//            if(curB!=null){
//                curB = curB.next;
//                ++lenB;
//            }
//        }
//        curA = headA;
//        curB = headB;
//        int diff = Math.abs(lenA-lenB);
//        for(int i=0; i<diff; ++i){
//            if(lenA>lenB){
//                curA = curA.next;
//            }
//            else{
//                curB = curB.next;
//            }
//        }
//        while(curA!=curB){
//            curA = curA.next;
//            curB = curB.next;
//        }
//        return curA;
//    }
    // solution...
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA!=curB){
            if(curA==null) curA = headB;
            else curA = curA.next;
            if(curB==null) curB = headA;
            else curB = curB.next;
        }
        return curA;
    }
}
