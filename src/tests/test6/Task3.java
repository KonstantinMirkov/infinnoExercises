package tests.test6;

public class Task3 {
    static final int LATIN_LETTERS_COUNT = 26;

    public static void main(String[] args) {
        String word1 = "alabala";
        System.out.println(firstNonRepeatingCharacter(word1)); // 3

        String word2 = "github";
        System.out.println(firstNonRepeatingCharacter(word2)); // 0

        String word3 = "alabalab";
        System.out.println(firstNonRepeatingCharacter(word3)); // -1

        String word4 = null;
        System.out.println(firstNonRepeatingCharacter(word4)); // -1
    }

    public static int firstNonRepeatingCharacter(String word) {
        if (word == null || word.isEmpty()) {
            return -1;
        }

        int[] charCounts = new int[LATIN_LETTERS_COUNT];
        for (int i = 0; i < word.length(); i++) {
            charCounts[word.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word.length(); i++) {
            if (charCounts[word.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
