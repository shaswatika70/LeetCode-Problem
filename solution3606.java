class Solution {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;

        Map<String, Integer> order = new HashMap<>();
        order.put("electronics", 0);
        order.put("grocery", 1);
        order.put("pharmacy", 2);
        order.put("restaurant", 3);

        List<String[]> valid = new ArrayList<>();

        for (int i = 0; i < n; i++) 
        {
            if (!isActive[i]) 
            continue;

            if (!order.containsKey(businessLine[i])) 
            continue;

            String cd = code[i];
            
            if (cd == null || cd.length() == 0) 
            continue;

            boolean ok = true;
            for (char c : cd.toCharArray()) 
            {
                if (c != '_' && !Character.isLetterOrDigit(c)) 
                {
                    ok = false;
                    break;
                }
            }
            if (!ok) continue;

            valid.add(new String[]{businessLine[i], cd});
        }

        Collections.sort(valid, (a, b) -> 
        {
            int p1 = order.get(a[0]);
            int p2 = order.get(b[0]);
            if (p1 != p2) return Integer.compare(p1, p2);
            return a[1].compareTo(b[1]);
        });

        List<String> answer = new ArrayList<>();
        for (String[] v : valid) answer.add(v[1]);
        return answer;
    }
}
