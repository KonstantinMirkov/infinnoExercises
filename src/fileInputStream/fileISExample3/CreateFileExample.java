package fileInputStream.fileISExample3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CreateFileExample {
    public static void main(String[] args) {
        String filename = "file.txt";
        String content = "Some text";

        try (FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
