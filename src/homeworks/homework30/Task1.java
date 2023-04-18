package homeworks.homework30;

import java.util.ArrayList;

public class Task1 {
    public static class CustomHashMap<K, V> {
        private ArrayList<Pair<K, V>>[] buckets;
        private int numBuckets;
        private int size;
        private static final double LOAD_FACTOR = 0.75;

        public CustomHashMap() {
            numBuckets = 16; // initial number of buckets
            size = 0;

            buckets = new ArrayList[numBuckets];
            for (int i = 0; i < numBuckets; i++) {
                buckets[i] = new ArrayList<>();
            }
        }

        public V get(Object key) {
            int bucketIndex = getBucketIndex(key);
            for (Pair<K, V> pair : buckets[bucketIndex]) {
                if (pair.key.equals(key)) {
                    return pair.value;
                }
            }

            return null;
        }

        public V put(K key, V value) {
            int bucketIndex = getBucketIndex(key);
            for (Pair<K, V> pair : buckets[bucketIndex]) {
                if (pair.key.equals(key)) {
                    V oldValue = pair.value;
                    pair.value = value;
                    return oldValue;
                }
            }

            buckets[bucketIndex].add(new Pair<K, V>(key, value));
            size++;
            if ((double)size / numBuckets >= LOAD_FACTOR) {
                resizeBuckets();
            }

            return null;
        }

        public V remove(Object key) {
            int bucketIndex = getBucketIndex(key);
            for (Pair<K, V> pair : buckets[bucketIndex]) {
                if (pair.key.equals(key)) {
                    buckets[bucketIndex].remove(pair);
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
            ArrayList<Pair<K, V>>[] oldBuckets = buckets;
            numBuckets *= 2;
            size = 0;
            buckets = new ArrayList[numBuckets];
            for (int i = 0; i < numBuckets; i++) {
                buckets[i] = new ArrayList<Pair<K, V>>();
            }
            for (ArrayList<Pair<K, V>> bucket : oldBuckets) {
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