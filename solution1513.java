class Solution {
    public int numSub(String s) {
        long a = 0, b = 0, mod = 1000000007;
        for (char c : s.toCharArray()) {
            if (c == '1') b++;
            else b = 0;
            a = (a + b) % mod;
        }
        return (int) a;
    }
}
