class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] result = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int org = nums.get(i);
            int cand = -1;
            for (int j = 1; j < org; j++) {
                if ((j | (j + 1)) == org) {
                    cand = j;
                    break;
                }
            }
            result[i] = cand;
        }
        return result;
    }
}
