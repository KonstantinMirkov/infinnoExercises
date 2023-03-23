package homeworks.homework5;

public class Task2 {
    public static void main(String[] args) {
        String s1 = "ala bala";
        String s2 = "la";
        int result = indexOf(s1, s2);
        System.out.println(result);

        s1 = "github";
        s2 = "hub";
        result = indexOf(s1, s2);
        System.out.println(result);

        s1 = "microsoft";
        s2 = "google";
        result = indexOf(s1, s2);
        System.out.println(result);
    }

    public static int indexOf(String s1, String s2) {
        return indexOf(s1, s2, 0);
    }

    public static int indexOf(String s1, String s2, int fromIndex) {
        int s1Length = s1.length();
        int s2Length = s2.length();

        if (s2Length > s1Length) {
            return -1;
        }

        int s1EndLen = s1Length - s2Length;

        outer:
        for (int i = fromIndex; i <= s1EndLen; i++) {
            int j;
            for (j = 0; j < s2Length; j++) {
                if (s1.charAt(i + j) != s2.charAt(j)) {
                    continue outer;
                }
            }
            return i;
        }

        return -1;
    }
}
