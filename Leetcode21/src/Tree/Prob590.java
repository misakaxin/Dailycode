package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author misakaxin
 */
public class Prob590 {
    List<Integer> list=new ArrayList();
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
    public List<Integer> postorder(Node root) {
        order(root);
        return list;
    }

    private void order(Node root) {
        if (root==null){
            return;
        }
        for (Node child:root.children) {
            order(child);
        }
        list.add(root.val);
    }

}
