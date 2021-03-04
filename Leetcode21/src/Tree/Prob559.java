package Tree;

import java.util.List;

public class Prob559 {

    class Node  {
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
    }

    public int maxDepth(Node root) {
        if (root==null){
            return 0;
        }
        int res = 1;

        for (Node node:root.children) {
            res = Math.max(res,1+maxDepth(node));
        }
        return res;
    }
}
