class Solution {
    public int binaryGap(int n) {
        int prev = -1; 
        int distance = 0;
        int pos = 0;
        while(n > 0){
            if((n & 1) == 1){
                if(prev != -1){
                    distance = Math.max(distance, pos - prev);
                }
                prev = pos;
            }
            n >>= 1;
            pos ++;
        }
        return distance;
    }
}
