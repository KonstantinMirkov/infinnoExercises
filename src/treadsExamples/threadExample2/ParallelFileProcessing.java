package treadsExamples.threadExample2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParallelFileProcessing {
    public static void main(String[] args) {
        String[] fileNames = {".\file1.txt", "C:\\Users\\Konstantin\\IdeaProjects\\infinnoHomeworks\\src\\treadsExamples\\threadExample1\\threadExample2\\file2.txt", "C:\\Users\\Konstantin\\IdeaProjects\\infinnoHomeworks\\src\\treadsExamples\\threadExample1\\threadExample2\\file3.txt"};

        List<Thread> threads = new ArrayList<>();

        for (String filename : fileNames) {
            Thread thread = new Thread(() -> {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(filename + " " + line);
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("All threads completed.");
    }
}
