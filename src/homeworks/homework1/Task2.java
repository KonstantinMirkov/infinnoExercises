package homeworks.homework1;

public class Task2 {
    public static void main(String[] args) {
        //пример: "abc", "dafc" => "ac"
        String word1 = "abcaa";
        String word2 = "dafc";

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