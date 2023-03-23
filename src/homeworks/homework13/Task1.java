package homeworks.homework13;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        NumberSet numberSet1 = new NumberSet(256);
        // Test add method
        numberSet1.add(1);
        numberSet1.add(2);
        numberSet1.add(2); // no duplicate
        numberSet1.add(3);
        System.out.println(numberSet1); // {1, 2, 3}

        // Test delete method
        numberSet1.delete(2);
        System.out.println(numberSet1); // {1, 3}

        // Test have method
        System.out.println(numberSet1.have(1)); // true
        System.out.println(numberSet1.have(2)); // false

        // Test size method
        System.out.println(numberSet1.size()); // 2

        // Test clear method
        numberSet1.clear();
        System.out.println(); // {}

        // Test values method
        numberSet1.add(4);
        numberSet1.add(5);
        int[] values = numberSet1.values();
        System.out.println(Arrays.toString(values)); // [4, 5]

        // Test equal method
        NumberSet numberSet2 = new NumberSet(256);
        numberSet2.add(4);
        numberSet2.add(5);
        System.out.println(numberSet1.equal(numberSet2)); // true
        numberSet2.add(6);
        System.out.println(numberSet1.equal(numberSet2)); // false

        // Test exception cases
        try {
            NumberSet numberSet3 = new NumberSet(-256);
            numberSet3.add(2);
            numberSet3.add(3);
            System.out.println(numberSet3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Capacity cannot be a negative number.
        }

        try {
            NumberSet numberSet3 = new NumberSet(256);
            numberSet3.add(33);
            System.out.println(numberSet3);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage()); // The number to add should not be below 0 and higher than 31.
        }

        try {
            NumberSet numberSet3 = new NumberSet(256);
            numberSet3.add(2);
            numberSet3.add(3);
            numberSet3.delete(33);
            System.out.println(numberSet3);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage()); // The number to delete should not be below 0 and higher than 31.
        }

        try {
            NumberSet numberSet3 = new NumberSet(256);
            numberSet3.add(2);
            numberSet3.add(3);
            System.out.println(numberSet3.equal(null));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage()); // Number sets should not be null.
        }
    }

    public static class NumberSet {
        private int[] set;
        private int size;

        public NumberSet(int capacity) {
            if (capacity < 0) {
                throw new IllegalArgumentException("Capacity cannot be a negative number.");
            }

            this.set = new int[capacity];
            this.size = 0;
        }

        public void add(int n) {
            if (n < 0 || n > 31) {
                throw new IndexOutOfBoundsException("The number to add should not be below 0 and higher than 31.");
            }

            if (!have(n)) {
                this.set[this.size++] = n;
            }
        }

        public void delete(int n) {
            if (n < 0 || n > 31) {
                throw new IndexOutOfBoundsException("The number to delete should not be below 0 and higher than 31.");
            }

            for (int i = 0; i < this.size; i++) {
                if (this.set[i] == n) {
                    this.set[i] = this.set[--this.size];
                    break;
                }
            }
        }

        public boolean have(int n) {
            for (int i = 0; i < size; i++) {
                if (set[i] == n) {
                    return true;
                }
            }
            return false;
        }

        public int size() {
            return size;
        }

        public void clear() {
            this.size = 0;
        }

        public int[] values() {
            return Arrays.copyOf(set, size);
        }

        public boolean equal(NumberSet set2) {
            if (set == null || set2 == null) {
                throw new NullPointerException("Number sets should not be null.");
            }

            if (this.size != set2.size) {
                return false;
            }

            for (int i = 0; i < this.size; i++) {
                if (!set2.have(this.set[i])) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");

            for (int i = 0; i < this.size; i++) {
                sb.append(this.set[i]);
                if (i != this.size - 1) {
                    sb.append(", ");
                }
            }

            sb.append("}");
            return sb.toString();
        }
    }
}