package homeworks.homework33;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        int size = 1000000;
        List<Integer> list = new Random().ints(size).boxed().collect(Collectors.toList());

        System.out.println(benchmark(list, l -> l.parallelStream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList())));
    }

    public static long benchmark(List<Integer> list, Consumer<List<Integer>> consumer) {
        long start = System.currentTimeMillis();
        consumer.accept(list);
        long end = System.currentTimeMillis();

        return end - start;
    }
}
