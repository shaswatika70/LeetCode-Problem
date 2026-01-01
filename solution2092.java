class Solution {
    
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        union(parent, 0, firstPerson);

       
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            List<int[]> sameTimeMeetings = new ArrayList<>();

         
            while (i < meetings.length && meetings[i][2] == time) {
                sameTimeMeetings.add(meetings[i]);
                i++;
            }

       
            Set<Integer> involved = new HashSet<>();
            for (int[] m : sameTimeMeetings) {
                union(parent, m[0], m[1]);
                involved.add(m[0]);
                involved.add(m[1]);
            }

           
            for (int person : involved) {
                if (find(parent, person) != find(parent, 0)) {
                    parent[person] = person;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (find(parent, p) == find(parent, 0)) {
                result.add(p);
            }
        }

        return result;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private void union(int[] parent, int a, int b) {
        parent[find(parent, a)] = find(parent, b);
    }
}
