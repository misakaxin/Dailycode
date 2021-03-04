package Tree;

public class Prob572 {


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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t==null){
            return true;
        }

        if (s==null){
            return false;
        }

        return isSubtree(s.left,t)||isSubtree(s.right,t)||isSame(s,t);

    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s==null && t==null){
            return true;
        }

        // 如果上面没有返回值，说明必有一个没有为空（有可能两个都不为空）
        if (s==null|| t==null){
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSame(s.left,t.left)&&isSame(s.right,t.right);
    }

}
