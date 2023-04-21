package homeworks.homework32;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static homeworks.homework32.Task2.FibonacciStream.generate;

public class Task2 {
    public static void main(String[] args) {
        generate().limit(10).forEach(System.out::println); // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
    }

    public static class FibonacciStream {
        public static Stream<Long> generate() {
            return Stream.generate(new FibonacciSupplier());
        }
    }

    static class FibonacciSupplier implements Supplier<Long> {
        private long a = 0;
        private long b = 1;

        @Override
        public Long get() {
            long result = a;
            a = b;
            b = result + b;
            return result;
        }
    }
}
