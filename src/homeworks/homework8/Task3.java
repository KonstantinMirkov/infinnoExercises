package homeworks.homework8;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(replaceChar("alabala", 'a', 'c'));
        System.out.println(replaceChar("alabala", 'l', 'x'));
        System.out.println(replaceChar(null, 'g', 'h'));
    }

    public static String replaceChar(String str, char ch1, char ch2) {
        if (str == null || str.length() == 0) {
            return "No string provided.";
        }

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch1) {
                chars[i] = ch2;
            }
        }

        return new String(chars);
    }
}
