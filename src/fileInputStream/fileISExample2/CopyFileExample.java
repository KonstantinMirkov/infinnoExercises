package fileInputStream.fileISExample2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileExample {
    public static void main(String[] args) {
        String sourceFile = "file.txt";
        String targetFile = "file4.txt";

        try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
             FileOutputStream fileOutputStream = new FileOutputStream(targetFile)) {
            int data;
            while ((data = fileInputStream.read()) != -1) {
                fileOutputStream.write(data);
                System.out.print((char) data);
            }

            System.out.println();
            System.out.println("The file is copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
