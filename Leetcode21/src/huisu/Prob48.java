package huisu;

import java.util.LinkedList;
import java.util.List;

/**
 * @author misakaxin
 */
public class Prob48 {
    public static List<List<Integer>> res =new LinkedList<>();
    public static List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> track =new LinkedList<>();
            backtrack(nums,track);
            return res;
        }
        private static void backtrack(int[] nums, LinkedList<Integer> track) {
         if (track.size() == nums.length){
             res.add(new LinkedList<>(track));
             return;
         }

            for (int num : nums) {
                if (track.contains(num)) {
                    continue;
                }
                track.add(num);
                backtrack(nums, track);
                track.removeLast();
            }
     }

     public static void main(String[] args) {
        int [] nums =new int[] {1, 2, 3,4};

        System.out.println(permute(nums));

     }

 }
