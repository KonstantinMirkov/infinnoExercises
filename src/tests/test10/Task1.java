package tests.test10;

import java.util.LinkedList;

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
        private LinkedList<Integer> linkedList;
        private int k;
        private int max;

        public LatestMax(int k) {
            this.k = k;
            linkedList = new LinkedList<>();
            max = Integer.MIN_VALUE;
        }

        public int add(int num) {
            if (linkedList.size() == k) {
                int removed = linkedList.poll();
                if (removed == max) {
                    max = Integer.MIN_VALUE;
                    for (int n : linkedList) {
                        max = Math.max(max, n);
                    }
                }
            }
            linkedList.offer(num);
            max = Math.max(max, num);
            return max;
        }
    }
}
