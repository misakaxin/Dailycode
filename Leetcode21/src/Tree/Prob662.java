package Tree;

import java.util.*;

/**
 * @author gy2020092401
 */
public class Prob662 {
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

    /*
    DFS:
    private int ans;
    private Map<Integer, Integer> posMap;
    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        posMap =new HashMap<>();
        dfs(root,0,0);
        return ans;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root==null){
            return;
        }
        posMap.computeIfAbsent(depth,x->pos);
        ans = Math.max(ans,pos-posMap.get(depth)+1);
        dfs(root.left,depth+1,2*pos);
        dfs(root.right,depth+1,2*pos+1);
    }
     */


    //BFS:

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> q=new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();

        q.offer(root);
        list.add(1);
        int depth = 1;

        while (!q.isEmpty()){
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                Integer curIndex = list.removeFirst();
                /* 划重点：这里判断是否到达终点 */
                /* 将 cur 的相邻节点加入队列 */
                if (cur.left!=null){
                     q.offer(cur.left);
                     list.add(curIndex * 2);
                }
                if (cur.right!=null){
                    q.offer(cur.right);
                    list.add(curIndex * 2 +1);
                }
            }
            if (list.size() > 1){
                depth = Math.max(depth,list.getLast()-list.getFirst()+1);
            }
        }
        return depth;
    }
}
