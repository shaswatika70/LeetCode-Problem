class Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007;

        long abc = 6; 
        long aba = 6; 
        for (int i = 2; i <= n; i++) {
            long newAbc = (2 * abc + 2 * aba) % MOD;
            long newAba = (2 * abc + 3 * aba) % MOD;
            abc = newAbc;
            aba = newAba;
        }

        return (int) ((abc + aba) % MOD);
    }
}
