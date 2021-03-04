package Tree;

public class Prob617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null){
            return t1;
        }

        TreeNode mergeNode=new TreeNode(t1.val+t2.val);

        mergeNode.left=mergeTrees(t1.left,t2.left);
        mergeNode.right=mergeTrees(t1.right,t2.right);

        return mergeNode;

    }



    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
