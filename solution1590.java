class Solution {
    public int minSubarray(int[] nums, int k) {
        long total = 0;
        for (int num : nums) 
        total += num;

        int rem = (int)(total % k);
        if (rem == 0) 
        return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  

        long prefix = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % k;
            int target = (int)((prefix - rem + k) % k);

            if (map.containsKey(target)) {
                ans = Math.min(ans, i - map.get(target));
            }

            map.put((int)prefix, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}
