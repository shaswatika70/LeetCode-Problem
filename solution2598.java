class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] a = new int[value];
        for (int x : nums) {
            int v = ((x % value) + value) % value;
            [v]++;
        }
        int mex = 0;
        while (mp[mex % value] > 0) {
            mp[mex % value]--;
            mex++;
        }
        return mex;
    }
}
