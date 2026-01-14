class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;

        for (int i = 1; i < points.length; i++) {
            int x1 = points[i - 1][0];
            int y1 = points[i - 1][1];
            int x2 = points[i][0];
            int y2 = points[i][1];

            while (x1 != x2 || y1 != y2) {
                if (x1 < x2) x1++;
                else if (x1 > x2) x1--;

                if (y1 < y2) y1++;
                else if (y1 > y2) y1--;

                time++;
            }
        }
        return time;
    }
}
