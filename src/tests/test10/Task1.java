package tests.test10;

public class Task1 {
    public static void main(String[] args) {
        int res;
        LatestMax data = new LatestMax(3);
        res = data.add(1);
        System.out.println(res); // 1
        res = data.add(0);
        System.out.println(res); // 1
        res = data.add(2);
        System.out.println(res); // 2
        res = data.add(1);
        System.out.println(res); // 2
        res = data.add(4);
        System.out.println(res); // 4
        res = data.add(0);
        System.out.println(res); // 4
        res = data.add(0);
        System.out.println(res); // 4
        res = data.add(0);
        System.out.println(res); // 0
    }

    public static class LatestMax {
        private int[] array;
        private int k;
        private int index;

        public LatestMax(int k) {
            this.k = k;
            array = new int[k];
            index = 0;
        }

        public int add(int num) {
            if (index == k) {
                index = 0;
            }

            array[index++] = num;

            int max = num;
            for (int n : array) {
                max = Math.max(max, n);
            }

            return max;
        }
    }
}
