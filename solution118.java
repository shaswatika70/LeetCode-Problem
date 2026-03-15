class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();

        for (int i = 0; i < numRows; i++)
        {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            
            for (int j = 1; j < i; j++)
            {
                row.add(prev.get(j - 1) + prev.get(j));
            }

            if (i > 0)
            {
                row.add(1);
            }

            result.add(row);
            prev = row;
        }

        return result;
        
    }
}
