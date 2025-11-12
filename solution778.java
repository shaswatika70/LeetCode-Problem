import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        // Min-heap storing (elevation, row, col)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int time = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int elevation = current[0];
            int r = current[1];
            int c = current[2];

            time = Math.max(time, elevation);

            // Reached destination
            if (r == n - 1 && c == n - 1) return time;

            if (visited[r][c]) continue;
            visited[r][c] = true;

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    pq.offer(new int[]{grid[nr][nc], nr, nc});
                }
            }
        }
        return time;
    }
}
