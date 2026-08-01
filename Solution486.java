class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length,i,j,len;
        int[][] x = new int[n][n];

        for (i=0; i<n; i++)
        {
            x[i][i] = nums[i];
        }

        for (len=2; len<=n; len++)
        {
            for (i=0; i<= n-len; i++)
            {
                j=i+len-1;
                x[i][j]=Math.max(nums[i]-x[i+1][j],nums[j]-x[i][j-1]);
            }
        }
        return x[0][n-1]>=0;
    }
}
