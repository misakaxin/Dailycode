package Tree;

/**
 * @author misakaxin
 */
public class Prob104 {
    public int maxDepth(Prob938.TreeNode root) {
        if (root==null){
            return 0;
        }
        else {
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }
}
