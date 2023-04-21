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

        String s1s1 = s1 + s1;
        return s1s1.contains(s2);
    }
}
