package homeworks.homework6;

public class Task2 {
    public static void main(String[] args) {
        String str1 = "abc#";
        String changedStr = removePrecedingCharacters(str1);
        System.out.println(changedStr);

        String str2 = "a#bc";
        changedStr = removePrecedingCharacters(str2);
        System.out.println(changedStr);

        String str3 = "####abc";
        changedStr = removePrecedingCharacters(str3);
        System.out.println(changedStr);

        String str4 = "a##bc";
        changedStr = removePrecedingCharacters(str4);
        System.out.println(changedStr);
    }

    public static String removePrecedingCharacters(String str) {
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch == '#' && sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            } else if (ch != '#') {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
