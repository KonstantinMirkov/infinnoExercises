package homeworks.homework9;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(reverse("abc"));
        System.out.println(reverse("123"));
        System.out.println(reverse(""));
        System.out.println(reverse(null));
    }

    public static String reverse(String str) {
        if (str == null || str.length() == 0) {
            return "No string provided.";
        }

        return reverse(str, 0, str.length() - 1);
    }

    private static String reverse(String str, int left, int right) {
        if (left >= right) {
            return str.substring(left, right + 1);
        }

        char leftChar = str.charAt(left);
        char rightChar = str.charAt(right);
        String reversedSubstring = reverse(str, left + 1, right - 1);

        return rightChar + reversedSubstring + leftChar;
    }
}
