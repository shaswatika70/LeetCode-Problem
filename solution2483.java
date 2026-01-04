class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;

        for (char c : customers.toCharArray()) {
            if (c == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int bestHour = 0;

        for (int i = 0; i < customers.length(); i++) {
            char c = customers.charAt(i);

            if (c == 'Y') {
                penalty--; 
            } else {
                penalty++; 
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }
}
