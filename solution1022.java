class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int x)
    {
        if ( node == null)
        return 0;
        x = x * 2 + node.val;

        if ( node.left == null && node.right == null)
        {
            return x;
        }

        return dfs ( node.left, x) + dfs ( node.right, x);
    }
}
