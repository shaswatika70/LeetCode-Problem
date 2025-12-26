class Solution {

    public int countPartitions(int[] nums) {
        int Sum = 0;
        
        for (int x : nums) 
        {
            Sum += x;
        }

        return Sum % 2 == 0 ? nums.length - 1 : 0;
    }
}
