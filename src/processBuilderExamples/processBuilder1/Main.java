package processBuilderExamples.processBuilder1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "dir");
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
