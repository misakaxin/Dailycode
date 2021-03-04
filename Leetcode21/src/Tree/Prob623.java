package Tree;

public class Prob623 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root==null){
            return null;
        }

        if (d==1 || d==2){
            TreeNode node = new TreeNode(v);
            if (d==1){
                node.left = root;
                return node;
            }
            node.left = root.left;
            root.left = node;


            node = new TreeNode(v);
            node.right = root.right;
            root.right = node;

            return root;

        }
        addOneRow(root.left,v,d-1);
        addOneRow(root.right,v,d-1);
        return root;
    }
}
