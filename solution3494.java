class Solution {
    public long minTime(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        long[] times = new long[n];

        for (int j = 0; j < m; j++) {
            long curTime = 0;
            for (int i = 0; i < n; i++) {
                curTime =
                    Math.max(curTime, times[i]) + (long) a[i] * b[j];
            }
            times[n - 1] = curTime;
            for (int i = n - 2; i >= 0; i--) {
                times[i] = times[i + 1] - (long) a[i + 1] * b[j];
            }
        }
        return times[n - 1];
    }
}
