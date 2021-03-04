package dp;

public class Prob583 {
    public int minDistance(String word1, String word2) {
        int n =word1.length();
        int m = word2.length();
        if (n==0 || m==0){
            return 0;
        }

        int [][] dp =new int[n+1][m+1];

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }

        }
        return m-dp[n][m]+n-dp[n][m];
    }
}
