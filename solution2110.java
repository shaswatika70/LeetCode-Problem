class Solution {
    public long getDescentPeriods(int[] prices) {
        long x = 1;   
        long y = 1; 

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                y++;          
            } else {
                y = 1;        
            }
            x += y;
        }

        return x;
    }
}
