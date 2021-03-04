package Tree;

/**
 * @author misakaxin
 */
public class Prob543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum = Integer.MAX_VALUE;


    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }

        depth(root);
        return sum;

    }

    private int depth(TreeNode root) {
        if (root==null){
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        sum = Math.max(sum,left+right);

        return Math.max(left,right)+1;
    }
}
