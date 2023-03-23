package homeworks.homework15;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(setBit(1, 1)); // 3
        System.out.println(setBit(0, 2)); // 4

        System.out.println(clearBit(3, 0)); // 2
        System.out.println(clearBit(7, 1)); // 5

        System.out.println(toggleBit(0, 1)); // 2
        System.out.println(toggleBit(5, 0)); // 4

        System.out.println(getBit(5, 0));// true
        System.out.println(getBit(4, 0)); // false
    }

    public static int setBit(int num, int index) {
        return num | (1 << index);
    }

    public static int clearBit(int num, int index) {
        return num & ~(1 << index);
    }

    public static int toggleBit(int num, int index) {
        return num ^ (1 << index);
    }

    public static boolean getBit(int num, int index) {
        return ((num >> index) & 1) == 1;
    }
}