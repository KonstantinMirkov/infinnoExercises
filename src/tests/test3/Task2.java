package tests.test3;

public class Task2 {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(isConsecutive(str));

        str = "1212";
        System.out.println(isConsecutive(str));

        str = "alaala";
        System.out.println(isConsecutive(str));

        str = "alaal";
        System.out.println(isConsecutive(str));

        str = "zzzzz";
        System.out.println(isConsecutive(str));

        str = "acacac";
        System.out.println(isConsecutive(str));

        str = "acaca";
        System.out.println(isConsecutive(str));

        str = null;
        System.out.println(isConsecutive(str));
    }

    public static boolean isConsecutive(String str) {
        if (str == null || str.length() == 0) {
            System.out.print("No string provided - ");
            return false;
        }

        int len = str.length();
        String substring;

        int halfLen = len / 2;
        for (int i = 1; i <= halfLen; i++) {
            if (len % i == 0) {
                substring = str.substring(0, i);

                StringBuilder sb = new StringBuilder();
                while (sb.length() < len) {
                    sb.append(substring);
                }

                if (sb.toString().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
