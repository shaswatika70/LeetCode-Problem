class Solution {
    private Set<Long> sums = new HashSet<>();
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        long total = dfs(root);

        long best = 0;
        for (long s : sums) {
            long product = s * (total - s);
            best = Math.max(best, product);
        }

        return (int) (best % MOD);
    }

    private long dfs(TreeNode node) {
        if (node == null) return 0;

        long sum = node.val + dfs(node.left) + dfs(node.right);
        sums.add(sum);
        return sum;
    }
}
