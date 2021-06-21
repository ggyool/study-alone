package LongestHappyString;

import java.util.PriorityQueue;
import java.util.Stack;

public class LongestHappyString {

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Node> pq = generatePQ(a, b, c);
        return solve(pq);
    }

    public PriorityQueue<Node> generatePQ(int a, int b, int c) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node("a", a));
        pq.add(new Node("b", b));
        pq.add(new Node("c", c));
        return pq;
    }

    public String solve(PriorityQueue<Node> pq) {
        StringBuffer sb = new StringBuffer();
        String bebef = "";
        String bef = "";
        Stack<Node> stk = new Stack<>();

        while (!pq.isEmpty()) {
            Node bigNode = pq.poll();
            if (bigNode.isZeroCount()) {
                continue;
            }
            if (isThirdSequence(bigNode, bef, bebef)) {
                stk.add(bigNode);
                continue;
            }
            // update before char
            bebef = bef;
            bef = bigNode.getAlpha();
            // append String to return value
            sb.append(bigNode.getAlpha());
            pq.add(new Node(bigNode.getAlpha(), bigNode.getCount() - 1));
            while (!stk.isEmpty()) {
                pq.add(stk.pop());
            }
        }
        return sb.toString();
    }

    public boolean isThirdSequence(Node bigNode, String bef, String bebef) {
        String alpha = bigNode.getAlpha();
        return alpha.equals(bef) && alpha.equals(bebef);
    }

    public static void main(String[] args) {
        LongestHappyString longestHappyString = new LongestHappyString();
        System.out.println(longestHappyString.longestDiverseString(1, 1, 7));
    }
}

class Node implements Comparable<Node> {

    private String alpha;
    private int count;

    public Node(String alpha, int count) {
        this.alpha = alpha;
        this.count = count;
    }

    public boolean isZeroCount() {
        return count == 0;
    }

    public String getAlpha() {
        return alpha;
    }

    public int getCount() {
        return count;
    }

    @Override
    public int compareTo(Node o) {
        return o.count - count;
    }
}
