class Solution {
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        List<Integer>[] tree = new ArrayList[n];
        for(int i = 0; i < n; i++){
            tree[i] = new ArrayList<>();
        }
        for(int[] e : hierarchy){
           
            tree[e[0] - 1].add(e[1] - 1);
        }

       
        int[][][] ans = dfs(0, -1, tree, present, future, budget);
        
        return ans[0][0][budget];
    }

    private int[][][] dfs(int u, int parent, List<Integer>[] tree, int[] present, int[] future, int budget) {
        
        int[] dp0 = new int[budget + 1];
        int[] dp1 = new int[budget + 1];

        for(int v : tree[u]){
            if(v == parent) continue;
            int[][][] child = dfs(v, u, tree, present, future, budget);
            int[] childNo = child[0][0], childYes = child[1][0];

            dp0 = merge(dp0, childNo, budget);
            dp1 = merge(dp1, childYes, budget);
        }

        
        int[] newDp0 = Arrays.copyOf(dp0, budget + 1);
        int[] newDp1 = Arrays.copyOf(dp0, budget + 1);

        int costNormal = present[u];
        int costDiscount = present[u] / 2;
        int gainNormal = future[u] - costNormal;
        int gainDiscount = future[u] - costDiscount;

     
        for(int b = costNormal; b <= budget; b++){
            newDp0[b] = Math.max(newDp0[b], dp1[b - costNormal] + gainNormal);
        }

        for(int b = costDiscount; b <= budget; b++){
            newDp1[b] = Math.max(newDp1[b], dp1[b - costDiscount] + gainDiscount);
        }

        return new int[][][]{ { newDp0 }, { newDp1 } };
    }


    private int[] merge(int[] dpA, int[] dpB, int budget){
        int[] merged = new int[budget + 1];
        for(int i = 0; i <= budget; i++){
            for(int j = 0; j + i <= budget; j++){
                merged[i + j] = Math.max(merged[i + j], dpA[i] + dpB[j]);
            }
        }
        return merged;
    }
}
