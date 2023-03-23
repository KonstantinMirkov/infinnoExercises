package homeworks.homework8;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(removeCharFromString("alabala", 2));
        System.out.println(removeCharFromString("alabala", 6));
        System.out.println(removeCharFromString(null, 2));
    }

    public static String removeCharFromString(String str, int position) {
        if (str == null || str.length() == 0) {
            return "No string provided.";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i != position) {
                result.append(str.charAt(i));
            }
        }

        return result.toString();
    }
}
