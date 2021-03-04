package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gy2020092401
 */
public class Prob513 {
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

    public int findBottomLeftValue(TreeNode root) {
        if (root==null){
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int res = 0;

        while (!q.isEmpty()){
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散
             */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /*判断是否到达终点
                 */
                if (cur.right==null && cur.left ==null){
                    res = cur.val;
                }
                if (cur.right != null){
                    q.offer(cur.right);
                }

                if (cur.left !=null){
                    q.offer(cur.left);
                }
            }
        }
        return res;
    }
}
