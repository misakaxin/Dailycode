package Tree;

public class Prob606 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }

    public String tree2str(TreeNode t) {
        if (t==null){
            return "";
        }
        if (t.left==null &&t.right==null){
            return t.val+"";
        }

        if (t.right==null){
            return t.val+"("+tree2str(t.left)+")";
        }

        return t.val+"("+tree2str(t.left)+")"+"("+tree2str(t.right)+")";
    }


}
