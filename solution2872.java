class Solution {
    int result = 0;
    List<List<Integer>> graph;
    int k;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
       this.k = k;
         n = values.length;
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        dfs(0, -1, values);

        return result;
    }

    private long dfs(int node, int parent, int[] values) {
        long sum = values[node];

        for (int nei : graph.get(node)) {
            if (nei == parent) continue;
            sum += dfs(nei, node, values);
        }

        if (sum % k == 0) {
            result++;   
            return 0;   
        }

        return sum; 
    }
}
