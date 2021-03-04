package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gy2020092401
 */
public class Prob515 {

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


    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root,res,0);


        return res;
    }
    private void dfs(TreeNode root, List<Integer> res, int i){

        if (root==null){
            return;
        }

        if (i<res.size()){
            res.set(i,Math.max(res.get(i),root.val));
        }else {
            res.add(root.val);
        }
        dfs(root.left,res,i+1);
        dfs(root.right,res,i+1);
    }
}
