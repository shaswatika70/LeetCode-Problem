class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // Convert broken letters into a set for fast lookup
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }

        int count = 0;
        String[] words = text.split(" ");

        // Check each word
        for (String word : words) {
            boolean canType = true;
            for (char c : word.toCharArray()) {
                if (broken[c - 'a']) {
                    canType = false;
                    break;
                }
            }
            if (canType) {
                count++;
            }
        }

        return count;
    }
}
