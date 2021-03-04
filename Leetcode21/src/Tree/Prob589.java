package Tree;

import java.util.ArrayList;
import java.util.List;

public class Prob589 {
    
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    private List<Integer> preorderList = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root==null){
            return preorderList;
        }

        preorderList.add(root.val);
        for (Node node:root.children) {
            preorder(node);
        }
        return preorderList;
    }
}
