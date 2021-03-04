package Tree;

import java.util.ArrayList;
import java.util.List;

public class Prob530 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int ans =Integer.MAX_VALUE;
    private Integer pre;
    public int getMinimumDifference(TreeNode root) {

        return inOrder(root);

    }

    private int inOrder(TreeNode root) {
        if (root==null){
            return 0;
        }

        inOrder(root.left);
        if (pre !=null){
            ans = Math.min(ans,Math.abs(pre -root.val));
        }

        pre = root.val;

        inOrder(root.right);

        return ans;
    }

}
