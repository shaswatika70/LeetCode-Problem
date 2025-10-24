class Solution {
  private long gcd(long a, long b) {
    while (b !=0) { 
        long t = b;
        b = a % b;
        a = t;
    }
    return a;
    }
    private long lcm(long a, long b){
        return (a / gcd(a,b)) * b;
    }

    public List<Integer> replaceNonCoprimes(int[] nums){
        Stack<Long> stack = new Stack<>();

        for(int num : nums){
            long cur = num;
            while (!stack.isEmpty()){
                long top = stack.peek();
                long g = gcd(top, cur);
                if (g == 1) break;
                cur = lcm(top, cur);
                stack.pop();
            }
            stack.push(cur);
        }

    List<Integer> result = new ArrayList<>();
    for (long val : stack){
        result.add((int)val);
    }
    return result;
}
}
