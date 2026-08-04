class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int i,j;
        List<Integer> ans = new ArrayList<>();

        for (i = 0; i < nums.length - 1 ; i++)
        {
            for (j = nums[i] + 1; j < nums[i + 1]; j++)
            {
                ans.add(j);
            }
        }
        return ans;
    }
}
