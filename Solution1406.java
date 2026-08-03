class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length,i,j,best;
        int[] dp = new int[n+1];
        dp[n] = 0;

        for (i=n-1; i>=0; i--)
        {
            best = Integer.MIN_VALUE;
            int sum=0;
            for (j=1; j<=3; j++)
            {
                if(i+j-1>=n) break;
                sum += stoneValue[i+j-1];
                best = Math.max(best, sum - dp[i+j]);
            }
            dp[i] = best;
        }
        if (dp[0]>0) return "Alice";
        if (dp[0]<0) return "Bob";
        return "Tie";
    }
}
