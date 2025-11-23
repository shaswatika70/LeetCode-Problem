class Solution {

    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int a = 0;
        int b = Integer.MIN_VALUE;
        for (int z : nums) {
            int x = Math.min(Math.max(z - k, b + 1), z + k);
            if (x > b) {
                a++;
                b = x;
            }
        }
        return a;
    }
}
