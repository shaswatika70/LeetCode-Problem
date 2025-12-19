class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int value = 0;

        for ( int x : nums)
        {
            value = (value * 2 + x) % 5;
            result.add(value == 0);
        }

        return result;
    }
}
