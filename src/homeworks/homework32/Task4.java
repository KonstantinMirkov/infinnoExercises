package homeworks.homework32;

import java.util.stream.Stream;

import static homeworks.homework32.Task4.StreamUtils.toStream;

public class Task4 {
    public static void main(String[] args) {
        String[] array = {"one", "two", "three"};
        Stream<String> stream = toStream(array);
        stream.forEach(System.out::println);
    }

    public static class StreamUtils {
        public static <T> Stream<T> toStream(T[] array) {
            Stream.Builder<T> builder = Stream.builder();
            for (T element : array) {
                builder.add(element);
            }
            return builder.build();
        }
    }
}
