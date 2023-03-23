package homeworks.homework7;

public class Task2 {
    public static void main(String[] args) {
        String str1 = "  abc  ";
        String str2 = "abc";
        System.out.println(areStringsEqual(str1, str2));

        str1 = "ABC";
        str2 = "abc";
        System.out.println(areStringsEqual(str1, str2));

        str1 = "ala   bala";
        str2 = "ala bala";
        System.out.println(areStringsEqual(str1, str2));

        str1 = "ала bala";
        str2 = "alabala";
        System.out.println(areStringsEqual(str1, str2));

        str1 = null;
        str2 = "alabala";
        System.out.println(areStringsEqual(str1, str2));
    }

    public static boolean areStringsEqual(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        str1 = removeSpaces(str1);
        str2 = removeSpaces(str2);

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        return str1.equals(str2);
    }

    public static String removeSpaces(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
