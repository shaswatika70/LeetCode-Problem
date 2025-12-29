import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
    
        Map<Integer, List<Integer>> rows = new HashMap<>();
        
        Map<Integer, List<Integer>> cols = new HashMap<>();

       
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            rows.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            cols.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        
        for (List<Integer> ys : rows.values()) {
            Collections.sort(ys);
        }
        for (List<Integer> xs : cols.values()) {
            Collections.sort(xs);
        }

        int coveredCount = 0;

        
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            List<Integer> ys = rows.get(x);
            List<Integer> xs = cols.get(y);

           
            if (ys.get(0) < y && y < ys.get(ys.size() - 1)
                && xs.get(0) < x && x < xs.get(xs.size() - 1)) {
                coveredCount++;
            }
        }

        return coveredCount;
    }
}
