class Solution {
    public int minimumOneBitOperations(int n) {
        int x = 0;
        while (n > 0) {
            x ^= n;
            n >>= 1;
        }
        return x;
    }
}
