class Solution {
    public int numberOfWays(String corridor) {
        final long MOD = 1_000_000_007L;

        int seats = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') seats++;
        }

        
        if (seats == 0 || seats % 2 != 0) return 0;

        long ways = 1;
        int seatCount = 0;
        int plantsBetween = 0;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatCount++;
                
                if (seatCount > 2 && seatCount % 2 == 1) {
                    ways = (ways * (plantsBetween + 1)) % MOD;
                    plantsBetween = 0;
                }
            } else if (seatCount >= 2 && seatCount % 2 == 0) {
                plantsBetween++;
            }
        }

        return (int) ways;
    }
}
