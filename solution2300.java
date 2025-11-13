class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length;
        int n = potions.length;
        int[] ans = new int[m];
        java.util.Arrays.sort(potions);
        for (int i = 0; i < m; i++) {
            long spell = spells[i];
            if(spell == 0) {
                ans[i] = 0;
                continue;
            }
            long need = (success+spell - 1) / spell;
            int idx = lowerBound(potions,need);
            ans[i] = n - idx;
        }
        return ans;
    }
    private int lowerBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if((long)arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
