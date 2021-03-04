package Tree;

public class Prob110 {
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


    public boolean isBalanced(TreeNode root) {

        return height(root) >=0;
    }

    private int height(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight>=0 && rightHeight>=0 &&Math.abs(leftHeight-rightHeight) <= 1){
            return Math.max(leftHeight,rightHeight)+1;
        }
        else {
            return -1;
        }
    }
}
