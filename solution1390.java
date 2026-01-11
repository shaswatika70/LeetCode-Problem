class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            int tempSum = 0;
            int count = 0;

            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    int d1 = i;
                    int d2 = num / i;

                    if (d1 == d2) {
                        count++;
                        tempSum += d1;
                    } else {
                        count += 2;
                        tempSum += d1 + d2;
                    }

                    if (count > 4) break;
                }
            }

            if (count == 4) {
                sum += tempSum;
            }
        }

        return sum;
    }
}
