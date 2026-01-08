class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = row * col;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canCross(row, col, cells, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canCross(int row, int col, int[][] cells, int day) {
        boolean[][] flooded = new boolean[row][col];

        
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            flooded[r][c] = true;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

       
        for (int c = 0; c < col; c++) {
            if (!flooded[0][c]) {
                queue.offer(new int[]{0, c});
                visited[0][c] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            if (r == row - 1) return true;

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col
                        && !flooded[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return false;
    }
}
