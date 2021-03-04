package Tree;

/**
 * @author gy2020092401
 */
public class Prob538 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode preNode = null;
    public TreeNode convertBST(TreeNode root) {
        if (root==null){
            return null;
        }

        convertBST(root.right);

        if (preNode!=null){
            root.val = preNode.val+root.val;
        }
        preNode = root;

        convertBST(root.left);

        return root;
    }
}
