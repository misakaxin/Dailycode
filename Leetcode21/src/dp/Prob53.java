package dp;

public class Prob53 {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n==0){
            return 0;
        }

        int [] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
