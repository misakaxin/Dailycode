package Tree;

import java.util.TreeMap;

class Prob222 {

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


     public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
         return countNodes(root.left) + countNodes(root.right) + 1;
     }
 }
