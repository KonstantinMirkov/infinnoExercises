package homeworks.homework9;

public class Task1 {
    static final int LATIN_LETTERS_COUNT = 26;

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "cba";
        System.out.println(sameLetters(str1, str2));

        str1 = "abc";
        str2 = "ab";
        System.out.println(sameLetters(str1, str2));

        str1 = "ababc";
        str2 = "abcccc";
        System.out.println(sameLetters(str1, str2));

        str1 = "ababc";
        str2 = "abccccd";
        System.out.println(sameLetters(str1, str2));
    }

    public static boolean sameLetters(String str1, String str2) {
        if (str1 == null || str1.length() == 0 ||
                str2 == null || str2.length() == 0) {
            return false;
        }

        boolean[] charsInStr1 = new boolean[LATIN_LETTERS_COUNT];
        boolean[] charsInStr2 = new boolean[LATIN_LETTERS_COUNT];

        for (int i = 0; i < str1.length() || i < str2.length(); i++) {
            setCharInBooleanArray(str1, charsInStr1, i);
            setCharInBooleanArray(str2, charsInStr2, i);
        }

        for (int i = 0; i < LATIN_LETTERS_COUNT; i++) {
            if (charsInStr1[i] != charsInStr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static void setCharInBooleanArray(String str, boolean[] charsInStr, int i) {
        if (i < str.length()) {
            charsInStr[str.charAt(i) - 'a'] = true;
        }
    }
}
