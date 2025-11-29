class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2;
        int[] x = new int[n];
        int[] y = new int[2];
        int z = 0;

        for (int num : nums)
        {
            x[num]++;
            if (x[num] == 2)
            {
                y[z++] = num;
            }
        }
        return y;
    }
}
