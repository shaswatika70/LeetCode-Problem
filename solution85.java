class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[] height = new int[cols];
        int[] left = new int[cols];
        int[] right = new int[cols];

        Arrays.fill(right, cols);
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            int curLeft = 0, curRight = cols;

           
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1')
                    left[j] = Math.max(left[j], curLeft);
                else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }

        
            for (int j = cols - 1; j >= 0; j--) {
                if (matrix[i][j] == '1')
                    right[j] = Math.min(right[j], curRight);
                else {
                    right[j] = cols;
                    curRight = j;
                }
            }

         
            for (int j = 0; j < cols; j++) {
                maxArea = Math.max(maxArea,
                        height[j] * (right[j] - left[j]));
            }
        }
        return maxArea;
    }
}
