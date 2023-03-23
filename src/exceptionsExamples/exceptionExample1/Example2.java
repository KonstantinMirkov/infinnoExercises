package exceptionsExamples.exceptionExample1;

import java.io.*;

public class Example2 {
    public static void main(String[] args) {

    }

    public static void processedFile(String filePath) throws FileNotFoundException, IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            throw new FileNotFoundException("File not found " + filePath);
        } else if (!file.isFile()) {
            throw new IllegalArgumentException("File expected " + filePath);
        }

//        try (BufferedReader bufferedReader =new BufferedReader(new FileReader(file))) {
//
//            String line = " ";
//            while (line == bufferedReader.readLine() != null) {
//                //TODO processed each line
//            }
//        } catch (IOException e){
//
//        }
    }
}
