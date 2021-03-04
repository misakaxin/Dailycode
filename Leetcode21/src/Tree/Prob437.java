package Tree;

//前缀和
public class Prob437 {
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
    int count=0;
    public int pathSum(TreeNode root, int sum) {
         if (root==null){
             return 0;
         }
         sum(root,sum);
         pathSum(root.left,sum);
         pathSum(root.right,sum);
         return count;
    }

    private void sum(TreeNode root, int sum) {
        if (root==null){
            return;
        }


        sum-=root.val;

        if (sum==0){
            count++;
        }
        sum(root.left,sum);
        sum(root.right,sum);
    }
}
