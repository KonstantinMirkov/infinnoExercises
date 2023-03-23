package homeworks.homework17;

public class Task2 {
    public static void main(String[] args) {
        NumberSet set = new NumberSet(63);
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.have(1)); // true
        System.out.println(set.have(2)); // true
        System.out.println(set.have(3)); // true
        System.out.println(set.have(4)); // false
        set.delete(2);
        System.out.println(set.have(1)); // true
        System.out.println(set.have(2)); // false
        System.out.println(set.have(3)); // true
    }

    public static class NumberSet {
        private long set;
        private int n;

        public NumberSet(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("N cannot be a negative number.");
            }

            this.n = n;
            this.set = 0L;
        }

        public void add(int n) {
            if (n < 0 || n > this.n) {
                throw new IndexOutOfBoundsException("The number to add should not be below 0 and higher than n.");
            }

            this.set |= 1L << n;
        }

        public void delete(int n) {
            if (n < 0 || n > this.n) {
                throw new IndexOutOfBoundsException("The number to delete should not be below 0 and higher than n.");
            }

            set &= ~(1L << n);
        }

        public boolean have(int n) {
            return (set & (1L << n)) != 0;
        }

        public int size() {
            return n;
        }

        public void clear() {
            this.n = 0;
        }


        public boolean equal(NumberSet set2) {
            for (int i = 0; i < this.n; i++) {
                if (!set2.have((int) set)) {
                    return false;
                }
            }
            return true;
        }
    }
}
