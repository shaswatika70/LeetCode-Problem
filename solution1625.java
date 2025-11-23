class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        String smallest = s;

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (!seen.add(cur)) continue; 
            if (cur.compareTo(smallest) < 0) {
                smallest = cur;
            }

           
            char[] chars = cur.toCharArray();
            for (int i = 1; i < chars.length; i += 2) {
                int newDigit = ((chars[i] - '0') + a) % 10;
                chars[i] = (char) (newDigit + '0');
            }
            String added = new String(chars);
            if (!seen.contains(added)) {
                queue.offer(added);
            }

            
            String rotated = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);
            if (!seen.contains(rotated)) {
                queue.offer(rotated);
            }
        }

        return smallest;
    }
}
    
