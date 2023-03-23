package homeworks.homework9;

public class Task3 {
    public static void main(String[] args) {
        //Testing the merge method
        Range r1 = new Range(1, 3);
        Range r2 = new Range(2, 5);
        r1.merge(r2);
        System.out.println(r1); // => [1, 5]

        // Testing the overlaps method
        Range r3 = new Range(5, 15);
        System.out.println(r1.overlaps(r3)); // true
        Range r4 = new Range(11, 20);
        System.out.println(r1.overlaps(r4)); // false

        //Testing the contains method
        Range r5 = new Range(1, 10);
        System.out.println(r5.contains(6)); // true
        System.out.println(r5.contains(10)); // true
        System.out.println(r5.contains(12)); // false
        System.out.println(r5.contains(-1)); // false
    }

    public static class Range {
        private int start;
        private int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }


        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public boolean contains(int n) {
            return n >= start && n <= end;
        }

        public boolean overlaps(Range r) {
            return start <= r.end && r.start <= end;
        }

        public void merge(Range r) {
            if (overlaps(r)) {
                start = Math.min(start, r.start);
                end = Math.max(end, r.end);
            }
        }

        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
}

