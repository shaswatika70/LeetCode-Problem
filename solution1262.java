class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] x = new int[3];
        x[1] = x[2] = Integer.MIN_VALUE;

        for (int num : nums)
        {
            int[] z = x.clone();
            for (int r = 0; r < 3; r++)
            {
                int newR = (r + num) % 3;
                z[newR] = Math.max(z[newR], x[r] + num);
            }
            x = z;
        }
        return x[0];
    }
}
