package homeworks.homework29;

import java.util.PriorityQueue;

public class Task3 {
    public static void main(String[] args) {
        Large data = new Large(3);
        System.out.println(data.add(0));// null
        System.out.println(data.add(1));// null
        System.out.println(data.add(2));// 0
        System.out.println(data.add(1));// 0
        System.out.println(data.add(4));// 1
    }

    public static class Large {
        private int k;
        private PriorityQueue<Integer> minHeap;

        public Large(int k) {
            this.k = k;
            this.minHeap = new PriorityQueue<>(k);
        }

        public Integer add(int num) {
            if (minHeap.size() <= k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
            return minHeap.size() < k ? null : minHeap.peek();
        }
    }
}
