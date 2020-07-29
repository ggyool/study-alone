package CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    Node[] visited = new Node[101];
    public Node copyFunc(Node node){
        Node copyNode = visited[node.val];
        if(copyNode==null){
            copyNode = new Node(node.val);
            visited[node.val] = copyNode;
        }
        for(Node next : node.neighbors){
            Node copyNext = visited[next.val];
            if(copyNext!=null){
                copyNode.neighbors.add(copyNext);
            }
            else{
                copyNode.neighbors.add(copyFunc(next));
            }
        }
        return copyNode;
    }
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        return copyFunc(node);
    }
}
