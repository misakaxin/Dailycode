package dp;

import java.util.Arrays;

public class Prob1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        // 定义：计算 s1[i..] 和 s2[j..] 的最长公共子序列长度
        int[][] dp = new int[m + 1][n + 1];

        //base case

        if (m == 0 || n == 0) {
            return 0;
        }

        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
