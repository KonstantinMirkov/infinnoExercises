package homeworks.homework30;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        List<String> list = MyCollections.listOf("a", "b", "c");
        System.out.println("List: " + list);

        Set<Integer> set = MyCollections.setOf(1, 2, 3);
        System.out.println("Set: " + set);

        Map<String, Integer> map = MyCollections.mapOf("a", 1, "b", 2, "c", 3);
        System.out.println("Map: " + map);

        Map<String, Integer> map2 = MyCollections.mapOfEntries(
                new AbstractMap.SimpleEntry<>("a", 1),
                new AbstractMap.SimpleEntry<>("b", 2),
                new AbstractMap.SimpleEntry<>("c", 3)
        );
        System.out.println("Map of entries: " + map2);
    }

    public static class MyCollections {
        @SafeVarargs
        public static <E> List<E> listOf(E... elements) {
            Objects.requireNonNull(elements);

            return switch (elements.length) {
                case 0 -> Collections.emptyList();
                case 1 -> Collections.singletonList(elements[0]);
                default -> new ArrayList<>(Arrays.asList(elements));
            };
        }

        @SafeVarargs
        public static <E> Set<E> setOf(E... elements) {
            Objects.requireNonNull(elements);

            return switch (elements.length) {
                case 0 -> Collections.emptySet();
                case 1 -> Collections.singleton(elements[0]);
                default -> new HashSet<>(Arrays.asList(elements));
            };
        }

        public static <K, V> Map<K, V> mapOf(K k1, V v1, Object... keyValues) {
            if (keyValues.length % 2 == 1) {
                throw new IllegalArgumentException("Array is missing value for the last key.");
            }

            Map<K, V> map = new HashMap<>();
            map.put(k1, v1);

            for (int i = 0; i < keyValues.length; i += 2) {
                K key = (K) keyValues[i];
                V value = (V) keyValues[i + 1];
                map.put(key, value);
            }

            return map;
        }

        @SafeVarargs
        public static <K, V> Map<K, V> mapOfEntries(Map.Entry<? extends K, ? extends V>... entries) {
            Map<K, V> map = new HashMap<>();

            for (Map.Entry<? extends K, ? extends V> entry : entries) {
                map.put(entry.getKey(), entry.getValue());
            }

            return map;
        }
    }
}