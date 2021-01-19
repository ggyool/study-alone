package CreateSortedArraythroughInstructions;

import java.util.Set;
import java.util.TreeSet;

// segment tree
// bit
public class CreateSortedArraythroughInstructions {
    public int createSortedArray(int[] instructions) {

    }
}

class Node {
    int val;
    int count;
    Node left;
    Node right;

    public Node(int val, Node left, Node right) {
        this.count = 1;
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void addCount() {
        this.count++;
    }
}


