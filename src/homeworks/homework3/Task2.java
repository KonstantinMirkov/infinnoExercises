package homeworks.homework3;

public class Task2 {
    public static void main(String[] args) {
        String ipAddress = "255.255.255.255";

        long number = ipToNumber(ipAddress);

        System.out.println(number);
    }

    public static long ipToNumber(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");

        long result = 0;
        int index = 0;
        while (index < ipAddressInArray.length) {
            long ipAddressPartValue = Integer.parseInt(ipAddressInArray[index]);

            result += ( ipAddressPartValue << (8 * (3 - index)));

            index++;
        }

        return result;
    }
}
