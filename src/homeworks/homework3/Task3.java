package homeworks.homework3;

public class Task3 {
    public static void main(String[] args) {
        int number = 255;

        String hex = toHexadecimal(number);

        System.out.println(hex);
    }


    public static String toHexadecimal(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        int modulo;

        while (number > 0) {
            modulo = number % 16;

            if (modulo < 10) {
                stringBuilder.insert(0, modulo);
            } else {
                stringBuilder.insert(0, (char) ('a' + modulo - 10));
            }

            number /= 16;
        }

        if (stringBuilder.length() == 0) {
            return "0";
        }

        return stringBuilder.toString();
    }
}