

class Solution {
    public int[] validSequence(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();

        int[] lastOcc = new int[n2];
        Arrays.fill(lastOcc, -1);

        int i = n1 - 1;
        int j = n2 - 1;

        // Find the last possible position for each character
        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                lastOcc[j] = i;
                j--;
            }

            i--;
        }

        i = 0;
        j = 0;

        boolean swap = true;
        int[] ans = new int[n2];

        while (i < n1 && j < n2) {

            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                i++;
                j++;

            } else {

                if (swap && (j == n2 - 1 || i < lastOcc[j + 1])) {

                    ans[j] = i;
                    i++;
                    j++;
                    swap = false;

                } else {
                    i++;
                }
            }
        }

        if (j == n2) {
            return ans;
        }

        return new int[0];
    }
}

