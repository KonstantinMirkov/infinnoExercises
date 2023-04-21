package homeworks.homework30;

import java.util.LinkedList;

public class Task1 {
    public static class CustomHashMap<K, V> {
        private LinkedList<Pair<K, V>>[] buckets;
        private int numBuckets;
        private int size;
        private static final double RESIZE_FACTOR = 0.75;

        public CustomHashMap() {
            numBuckets = 16;
            size = 0;
            buckets = new LinkedList[numBuckets];
        }

        public V get(Object key) {
            int bucketIndex = getBucketIndex(key);

            LinkedList<Pair<K, V>> bucket = buckets[bucketIndex];
            if (bucket == null) {
                return null;
            }

            for (Pair<K, V> pair : bucket) {
                if (pair.key.equals(key)) {
                    return pair.value;
                }
            }

            return null;
        }

        public V put(K key, V value) {
            int bucketIndex = getBucketIndex(key);
            LinkedList<Pair<K, V>> bucket = buckets[bucketIndex];
            if (bucket == null) {
                bucket = new LinkedList<>();
                buckets[bucketIndex] = bucket;
            }

            for (Pair<K, V> pair : bucket) {
                if (pair.key.equals(key)) {
                    V oldValue = pair.value;
                    pair.value = value;
                    return oldValue;
                }
            }

            bucket.add(new Pair<>(key, value));
            size++;
            if ((double) size / numBuckets >= RESIZE_FACTOR) {
                resizeBuckets();
            }

            return null;
        }

        public V remove(Object key) {
            int bucketIndex = getBucketIndex(key);
            LinkedList<Pair<K, V>> bucket = buckets[bucketIndex];
            if (bucket == null) {
                return null;
            }

            for (Pair<K, V> pair : bucket) {
                if (pair.key.equals(key)) {
                    bucket.remove(pair);

                    if (bucket.size() == 0) {
                        buckets[bucketIndex] = null;
                    }

                    size--;
                    return pair.value;
                }
            }

            return null;
        }

        private int getBucketIndex(Object key) {
            return Math.abs(key.hashCode() % numBuckets);
        }

        private void resizeBuckets() {
            LinkedList<Pair<K, V>>[] oldBuckets = buckets;
            numBuckets *= 2;
            size = 0;

            buckets = new LinkedList[numBuckets];

            for (LinkedList<Pair<K, V>> bucket : oldBuckets) {
                if (bucket == null) {
                    continue;
                }

                for (Pair<K, V> pair : bucket) {
                    put(pair.key, pair.value);
                }
            }
        }

        private static class Pair<K, V> {
            K key;
            V value;

            public Pair(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}