package fileInputStream.fileISExample1;

import java.io.FileInputStream;
import java.io.IOException;

public class MyFileReader {
    public static void main(String[] args) {
        String filename = "file.txt";

        try (FileInputStream fileInputStream = new FileInputStream(filename)) {
            int data;
            while ((data = fileInputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}