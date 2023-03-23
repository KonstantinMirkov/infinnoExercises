package treadsExamples.treadExample1;

import java.util.concurrent.*;

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 10; i >= 1; i--) {
                System.out.println(i);
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();


        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                return 123;
            } catch (IllegalStateException e) {
                throw new IllegalStateException("Task interrupted, " + e);
            }
        };


        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> futureTask = executorService.submit(task);
        System.out.println(futureTask.isDone());

        try {
            executorService.shutdown();
            Integer result = futureTask.get(1, TimeUnit.SECONDS);
            System.out.println(futureTask.isDone());
            System.out.println(result);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
