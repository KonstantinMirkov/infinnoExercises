package tests.test7;

public class Task2 {
    public static void main(String[] args) {
        String str1 = "0";
        System.out.println(isNum(str1)); // true
        String str2 = "0.1";
        System.out.println(isNum(str2)); // true
        String str3 = "abc";
        System.out.println(isNum(str3)); // false
        String str4 = "1 a";
        System.out.println(isNum(str4)); // false
        String str5 = "2e10";
        System.out.println(isNum(str5)); // true
        String str6 = "1.234e2";
        System.out.println(isNum(str6)); // true
        String str7 = "1.2e2.5";
        System.out.println(isNum(str7)); // false
    }

    public static boolean isNum(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        int currentIndex = 0;
        if (str.charAt(currentIndex) == '+' || str.charAt(currentIndex) == '-') {
            currentIndex++;
        }

        boolean hasDecimalPoint = false;
        boolean hasExponent = false;
        while (currentIndex < str.length()) {
            char ch = str.charAt(currentIndex);
            if (ch >= '0' && ch <= '9') {
                currentIndex++;
            } else if (ch == '.') {
                if (hasDecimalPoint || hasExponent) {
                    return false;
                }
                hasDecimalPoint = true;
                currentIndex++;
            } else if (ch == 'e' || ch == 'E') {
                if (hasExponent) {
                    return false;
                }
                hasExponent = true;
                currentIndex++;
            } else {
                return false;
            }
        }
        return true;
    }
}