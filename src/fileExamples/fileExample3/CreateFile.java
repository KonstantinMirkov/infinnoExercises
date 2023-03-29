package fileExamples.fileExample3;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        File file = new File("file4.txt");

        try {
            boolean isFileCreated = file.createNewFile();
            if (isFileCreated) {
                System.out.println("The file is created.");
            } else {
                System.out.println("This file already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error with creating the file:");
            e.printStackTrace();
        }

    }
}
