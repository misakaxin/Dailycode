package dp;

import java.util.Arrays;

/**
 * @author gy2020092401
 */
public class Prob300 {



    public static int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        //base case:
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res=0;
        for (int j : dp) {
            res = Math.max(res, j);
        }
        return res;
    }



    public static void main(String[] args) {
        int [] nums=new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}







