class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        
        
        long[] s = new long[n + 1];
       
        long[] t = new long[n + 1];
        
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + (long)prices[i - 1] * strategy[i - 1];
            t[i] = t[i - 1] + prices[i - 1];
        }
        
        long ans = s[n];
        for (int i = k; i <= n; i++) {
            long originalSegment = s[i] - s[i - k];
            long newSegment = t[i] - t[i - k/2];
            long candidate = s[n] - originalSegment + newSegment;
            ans = Math.max(ans, candidate);
        }
        
        return ans;
    }
}
