package homeworks.homework3;

public class Task1 {
    public static void main(String[] args) {
        int number = 1;

        String ipAddress = numberToIpAddress(number);

        System.out.println(ipAddress);
    }

    public static String numberToIpAddress(int number) {
        int eightBits = 8;
        int sixteenBits = 16;
        int twentyFourBits = 24;

        int a = number & 0xFF;
        int b = (number >> eightBits) & 0xFF;
        int c = (number >> sixteenBits) & 0xFF;
        int d = (number >> twentyFourBits) & 0xFF;

        return String.format("%d.%d.%d.%d", d, c, b, a);
    }
}