class Solution {
    public boolean doesAliceWin(String s) {
       String vowels = "aeiou";
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                return true; 
            }
        }
        return false;
    }
}
