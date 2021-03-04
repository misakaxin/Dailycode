package Tree;


import static Tree.TreeUtill.convert;

/**
 * @author gy2020092401
 */
public class Prob687 {

    static int ans;
    public static int longestUnivaluePath(TreeUtill.TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public static int arrowLength(TreeUtill.TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);

        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft = left + 1;
        }

        if (node.right != null && node.right.val == node.val) {
            arrowRight = right + 1;
        }

        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);

    }

    public static void main(String[] args) {
        Integer [] nums = {3,3,null,3,3,null,null,null,3};
        TreeUtill.TreeNode root = convert(nums);
        System.out.println(longestUnivaluePath(root));
    }
}
