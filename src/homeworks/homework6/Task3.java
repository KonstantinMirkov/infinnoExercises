package homeworks.homework6;

public class Task3 {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "def";
        System.out.println(getCommonCharacters(word1, word2));

        word1 = "abc";
        word2 = "cde";
        System.out.println(getCommonCharacters(word1, word2));

        word1 = "abc";
        word2 = "dafc";
        System.out.println(getCommonCharacters(word1, word2));

        word1 = "abcaad";
        word2 = "deaf";
        System.out.println(getCommonCharacters(word1, word2));
    }

    public static String getCommonCharacters(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        for (char currentChar : word1.toCharArray()) {
            if (word2.indexOf(currentChar) >= 0 && result.toString().indexOf(currentChar) < 0) {
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}
