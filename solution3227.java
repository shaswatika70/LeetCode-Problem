class Solution {
    public boolean doesAliceWin(String s) {
       String vowels = "aeiou";
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                return true; // Alice can always win if there's at least one vowel
            }
        }
        return false;
    }
}
