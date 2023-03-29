package fileExamples.fileExample1;

import java.io.File;
import java.io.IOException;

public class MyFileClass {
    public static void main(String[] args) {
        File file = new File("file.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("The file is created.");
            } else {
                System.out.println("File with this name already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error with creating the file:");
            e.printStackTrace();
        }
    }
}
