package homeworks.homework21;

public class Task1 {
    public static void main(String[] args) {
        String[] testCases = {"0.1", ".3", "-0.1", "0.1.1", "+0.1", "abc", "1 a", "2e10", "1.234e2",
                "1.234e-2", "+1.234e-2", "1.2e2.5", "1.2e5e3", "1.2e", "e5", "", null};
        for (String testCase : testCases) {
            System.out.println(testCase + " -> " + isFloat(testCase));
        }
    }

    public static boolean isFloat(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        int start = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            start = 1;
        }

        int len = str.length();
        boolean hasDot = false;
        boolean hasExp = false;
        for (int i = start; i < len; i++) {
            char c = str.charAt(i);
            if (c == '.') {
                if (hasDot || hasExp) {
                    return false;
                }
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                if (hasExp || i == start || i == len - 1) {
                    return false;
                }
                hasExp = true;
                if (str.charAt(i + 1) == '-' || str.charAt(i + 1) == '+') {
                    i++;
                    if (i == len - 1) {
                        return false;
                    }
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
