class Solution {
    public int maximizeSquareHoleArea(int n, int m,
                                      int[] hBars, int[] vBars) {

        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxH = longestConsecutive(hBars);
        int maxV = longestConsecutive(vBars);

        int side = Math.min(maxH + 1, maxV + 1);
        return side * side;
    }

    private int longestConsecutive(int[] arr) {
        int maxLen = 0, cur = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                cur++;
            } else {
                maxLen = Math.max(maxLen, cur);
                cur = 1;
            }
        }
        return Math.max(maxLen, cur);
    }
}
