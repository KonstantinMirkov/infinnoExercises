package homeworks.homework2;

public class Task3 {
    public static void main(String[] args) {
        String text = "abc";
        int number = 255;

        System.out.println(encryptString(text, number));
    }

    public static String encryptString(String text, int number) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isUpperCase(currentChar)) {
                currentChar = (char) (((currentChar - 'A' + number) % 26) + 'A');
            } else if (Character.isLowerCase(currentChar)) {
                currentChar = (char) (((currentChar - 'a' + number) % 26) + 'a');
            }

            result.append(currentChar);
        }

        return result.toString();
    }
}