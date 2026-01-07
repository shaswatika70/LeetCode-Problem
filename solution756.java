class Solution {
    Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char val = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
        }

        return dfs(bottom);
    }

    private boolean dfs(String bottom) {
     
        if (bottom.length() == 1) return true;

       
        return buildNext(bottom, 0, new StringBuilder());
    }

    private boolean buildNext(String bottom, int index, StringBuilder next) {
        if (index == bottom.length() - 1) {
           
            return dfs(next.toString());
        }

        String key = bottom.substring(index, index + 2);
        if (!map.containsKey(key)) return false;

        for (char c : map.get(key)) {
            next.append(c);
            if (buildNext(bottom, index + 1, next)) return true;
            next.deleteCharAt(next.length() - 1); 
        }

        return false;
    }
}
