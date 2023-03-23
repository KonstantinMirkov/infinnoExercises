package treadsExamples.treadExample1;

import java.util.List;
import java.util.concurrent.*;

public class TreadsExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Callable<String>> callables = List.of(() -> "task1", () -> "task2", () -> "task3");

        try {
            List<Future<String>> futures = executorService.invokeAll(callables);
            futures.forEach(f -> {
                try {
                    System.out.println(f.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
