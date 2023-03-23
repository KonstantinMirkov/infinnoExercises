package treadsExamples.treadExample1;

import java.util.concurrent.Callable;

public class MyCallableThread implements Callable <String> {

    @Override
    public String call() {
        return "tasks";
    }
}
