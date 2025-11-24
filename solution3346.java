class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer,Integer> count = new HashMap<>();
        TreeMap<Integer,Integer> diff = new TreeMap<>();
        TreeSet<Integer> candidates = new TreeSet<>();

        for (int x : nums) {
            count.merge(x, 1, Integer::sum);
            diff.merge(x - k, 1, Integer::sum);
            diff.merge(x + k + 1, -1, Integer::sum);

            candidates.add(x);
            candidates.add(x - k);
            candidates.add(x + k + 1);
        }
         int ans = 1;
        int coverage = 0;

        for (int v : candidates) {
            coverage += diff.getOrDefault(v, 0);
            int already = count.getOrDefault(v, 0);
            int canChange = coverage - already;
            int total = already + Math.min(numOperations, canChange);
            ans = Math.max(ans, total);
        }

        return ans;
    }
}
