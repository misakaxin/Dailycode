package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob508 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root==null){
            return new int[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        dfs(root,map);

        List<Integer> list =new ArrayList<>();

        //取出max对应的key
        for (Integer a:map.keySet()) {
            if (map.get(a) ==max){
                list.add(a);
            }
        }

        int [] res =new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private int dfs(TreeNode root, Map<Integer, Integer> map) {

        if (root==null){
            return 0;
        }
        int left = dfs(root.left,map);
        int right = dfs(root.right,map);
        int val = left + right + root.val;

        map.put(val,map.getOrDefault(val,0)+1);

        max = Math.max(max,map.get(val));

        return val;
    }




}
