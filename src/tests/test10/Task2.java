package tests.test10;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(isRotation("alabala", "balaala")); // true
        System.out.println(isRotation("hello", "olleh")); // false
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            String rotated = s1.substring(i) + s1.substring(0, i);
            if (rotated.equals(s2)) {
                return true;
            }
        }

        return false;
    }
}
