package fileExamples.fileExample3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("file.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("text1");
            bufferedWriter.newLine();
            bufferedWriter.write("text2");
            bufferedWriter.close();


        } catch (IOException e) {
            System.out.println("Error while writing in the file");
            e.printStackTrace();
        }

    }
}
