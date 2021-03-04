package Tree;

import java.util.*;

public class Prob501 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static Map<Integer,Integer> map;
    public static int[] findMode(TreeNode root) {
        if (root==null){
            return new int[0];
        }
        map=new HashMap<>();
        dfs(root);

        int max = map.get(root.val);


        for (Integer num: map.values() ) {
            if (max<num){
                max=num;
            }
        }

        List<Integer> list = new ArrayList();

        for (int a: map.keySet()) {
            if (map.get(a) ==max){
                list.add(a);
            }
        }
        int [] a=new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }

        return a;

    }

    private static void dfs(TreeNode root) {
        if (root==null){
            return;
        }
        map.put(root.val, map.getOrDefault(root.val,0)+1);
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {


        TreeNode res =new TreeNode(2147483647);
        for (int i = 0; i < findMode(res).length; i++) {
            System.out.println(findMode(res)[i]);
        }

    }

}
