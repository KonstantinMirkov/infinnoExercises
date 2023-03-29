package fileExamples.fileExample4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) {
        try {
            Path source = Paths.get("C:\\Users\\Konstantin\\IdeaProjects\\infinnoHomeworks\\file.txt");
            Path destination = Path.of("C:\\Users\\Konstantin\\IdeaProjects\\infinnoHomeworks\\file5.txt");
            List<String> lines = Files.readAllLines(source);

            lines.forEach(System.out::println);

            Files.copy(source, destination);
        } catch (IOException e) {
            System.out.println("Error reading lines");
            e.printStackTrace();
        }

    }
}
