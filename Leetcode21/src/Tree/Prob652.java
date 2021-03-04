package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob652 {
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
    Map<String,Integer> count;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        res = new ArrayList<>();

        dfs(root);
        return res;


    }

    private String dfs(TreeNode root) {
        if (root == null){
            return "#";
        }

        String serial = root.val +","+ dfs(root.left) +","+ dfs(root.right);

        count.put(serial,count.getOrDefault(serial,0)+1);

        if (count.get(serial) == 2){
            res.add(root);
        }

        return serial;
    }
}
