class Solution {
    public int countOperations(int num1, int num2) {
        int x = 0;
        while (num1 != 0 && num2 !=0) {
            x += num1 / num2;
            num1 %= num2;

            int z = num1;
            num1 = num2;
            num2 = z;
        }
        return x;
    }
}
