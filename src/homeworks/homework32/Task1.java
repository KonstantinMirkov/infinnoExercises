package homeworks.homework32;

import java.util.*;
import java.util.stream.*;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Set<String> set = Set.of("a", "b", "c", "d", "e");
        String[] array = {"x", "y", "z"};

        System.out.println(StreamConverter.toStream(list)); //java.util.stream.SliceOps$1@15aeb7ab
        System.out.println("List stream: " + StreamConverter.toStream(list).toList()); //[1, 2, 3, 4, 5]
        System.out.println(StreamConverter.toStream(set)); //java.util.stream.SliceOps$1@7cc355be
        System.out.println("Set stream: " + StreamConverter.toStream(set).collect(Collectors.toSet())); //[a, b, c, d, e]
        System.out.println(StreamConverter.toStream(array)); //java.util.stream.SliceOps$1@34c45dca
        System.out.println("Array stream: " + StreamConverter.toStream(array).toList()); //[x, y, z]
    }

    public static class StreamConverter {
        public static <T> Stream<T> toStream(List<T> list) {
            Iterator<T> iterator = list.iterator();
            Iterable<T> iterable = () -> iterator;
            return Stream.generate(iterable.iterator()::next)
                    .limit(list.size());
        }

        public static <T> Stream<T> toStream(Set<T> set) {
            Iterator<T> iterator = set.iterator();
            Iterable<T> iterable = () -> iterator;
            return Stream.generate(iterable.iterator()::next)
                    .limit(set.size());
        }

        public static <T> Stream<T> toStream(T[] array) {
            Iterator<T> iterator = Arrays.asList(array).iterator();
            Iterable<T> iterable = () -> iterator;
            return Stream.generate(iterable.iterator()::next)
                    .limit(array.length);
        }
    }
}
