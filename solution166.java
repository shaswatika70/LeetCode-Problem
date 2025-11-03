
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) sb.append("-");
        
        // Convert to long to avoid overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Integer part
        sb.append(num / den);
        num %= den;
        
        if (num == 0) return sb.toString(); // No fractional part
        
        sb.append(".");
        
        // Map to store remainder and its position
        Map<Long, Integer> map = new HashMap<>();
        
        while (num != 0) {
            if (map.containsKey(num)) {
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            map.put(num, sb.length());
            
            num *= 10;
            sb.append(num / den);
            num %= den;
        }
        
        return sb.toString();
    }
}
