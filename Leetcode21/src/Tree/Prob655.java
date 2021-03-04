package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author misakaxin
 */
public class Prob655 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<String>> printTree(TreeNode root) {
        //获取二叉树深度
        int height = getHeight(root);

        String[][] res = new String[height][(1<<height)-1];
        //填充“”
        for (String[] arr:res) {
            Arrays.fill(arr,"");
        }

        List<List<String>> ans = new ArrayList<>();

        fill(res,root,0,0,res[0].length);

        //数组转化成List集合
        for (String[] arr:res) {
           ans.add(Arrays.asList(arr));
        }
        return ans;
    }

    private void fill(String[][] res, TreeNode root, int i, int l, int r) {
        if (root==null){
            return;
        }

        res[i][(l+r)/2] = ""+root.val;
        fill(res,root.left,i+1,l,(l+r)/2);
        fill(res,root.right,i+1,(l+r+1)/2,r);
    }

    private int getHeight(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

}
