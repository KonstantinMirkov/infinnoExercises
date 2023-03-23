package tests.test5;

import java.util.LinkedList;

public class Task2 {
    public static void main(String[] args) {
        Average avg = new Average(3);
        float val;

        val = avg.next(1); // 1.0
        System.out.println(val);

        val = avg.next(2); // 1.5
        System.out.println(val);

        val = avg.next(3); // 2.0
        System.out.println(val);

        val = avg.next(4); // 3.0
        System.out.println(val);

        val = avg.next(5); // 4.0
        System.out.println(val);

        val = avg.next(0); // 3.0
        System.out.println(val);
    }

    public static class Average {

        private int n;
        private LinkedList<Integer> numbersList;
        private float sum;

        public Average(int n) {
            if (n < 1) {
                throw new IllegalArgumentException("The average of at least one number must be insert.");
            }

            this.n = n;
            this.numbersList = new LinkedList<>();
            this.sum = 0;
        }

        public float next(int num) {
            this.numbersList.offer(num);
            this.sum += num;

            if (this.numbersList.size() > n) {
                this.sum -= this.numbersList.remove();
            }

            return this.sum / this.numbersList.size();
        }
    }
}