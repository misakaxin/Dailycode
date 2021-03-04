package dp;

import java.util.Arrays;

class Prob509 {
    public int fib(int N) {
        int[] dp=new int[N+1];
        Arrays.fill(dp,0);
        if (N < 1){ return 0;}
        if (N == 1 || N == 2){ return 1;}
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for (int i = 3; i <dp.length ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[N];
    }
}
