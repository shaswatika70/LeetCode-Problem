class Solution {
    public int minimumOperations(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            int y = x % 3;
            sum += Math.min(y, 3 - y);
        }
        return sum;
    }
}
