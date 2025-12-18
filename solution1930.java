class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length(); 
        char[] A = s.toCharArray();

        int[] First = new int[26];
        int[] Last = new int[26];

        for (int i = 0; i < 26; i++)
        {
            First[i] = Integer.MAX_VALUE;
            Last[i] = -1;
        }

        for (int i = 0; i < n; i++)
        {
            int c = A[i] - 'a';
            First[c] = Math.min(First[c], i);
            Last[c] = Math.max(Last[c], i);
        }

        int count = 0;

        for (int c = 0; c < 26; c++)
        {
            int L = First[c];
            int R = Last[c];

            if (R - L < 2) continue;

            HashSet<Character> set = new HashSet<>();

            for (int i = L + 1; i < R; i++)
            {
                set.add(A[i]);
            }

            count += set.size();

        }

        return count;
    }
}
