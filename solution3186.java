class Solution 
{

    public long maximumTotalDamage(int[] po) 
    {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int p : po) 
        {
            count.put(p, count.getOrDefault(p, 0) + 1);
        }
        List<int[]> S = new ArrayList<>();
        S.add(new int[] { -1000, 0 });
        for (Map.Entry<Integer, Integer> e : count.entrySet()) 
        {
            S.add(new int[] { e.getKey(), e.getValue() });
        }
        int n = S.size();
        long[] f = new long[n];
        long x = 0;
        long y = 0;
        int j = 1;
        for (int i = 1; i < n; i++) 
        {
            while (j < i && S.get(j)[0] < S.get(i)[0] - 2) 
            {
                x = Math.max(x, f[j]);
                j++;
            }
            f[i] = x + 1L * S.get(i)[0] * S.get(i)[1];
            y = Math.max(y, f[i]);
        }
        return y;
    }
}
