package fileLockingExamples.fileLockingExample1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String fileName = "test.txt";
        String content1 = "testing1";
        String content2 = "testing2";

        FileWriteThread fileWriteThread1 = new FileWriteThread(fileName, content1);
        FileWriteThread fileWriteThread2 = new FileWriteThread(fileName, content2);

        fileWriteThread1.start();
        fileWriteThread2.start();

        Thread.currentThread().join();
    }

    public static void writeFileWithLock(String filename, String content, String threadName) {
        Path filepath = Paths.get(filename);

        try (FileChannel fileChannel = FileChannel.open(filepath,
                StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            try (FileLock fileLock = fileChannel.tryLock()) {
                if (fileLock != null) {
                    Thread.sleep(100L);
                    fileChannel.write(ByteBuffer.wrap(content.getBytes()));
                    System.out.println("Locked the file successfully: " + threadName + " : " + content);
                } else {
                    System.out.println("Locked the file unsuccessfully");
                }
            } catch (IOException | InterruptedException | OverlappingFileLockException e) {
                System.out.println(e.getMessage() + " " + threadName);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage() + " " + threadName);
        }
    }
}
