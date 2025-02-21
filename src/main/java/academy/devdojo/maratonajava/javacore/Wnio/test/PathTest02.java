package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest02 {
    public static void main(String[] args) throws IOException {
        Path pastaPath = Paths.get("pasta");
        if (Files.notExists(pastaPath)) {
            Path pastaDirectory = Files.createDirectory(pastaPath);
        }else{
            System.out.println("Directory already exists");
        }

        Path subPastaPath = Paths.get("pasta/subPasta/sub_pasta_2");
        Path subPastaDirectory = Files.createDirectories(subPastaPath);

        Path filePath = Paths.get(subPastaPath.toString(), "file.txt");

        if (Files.notExists(filePath)) {
            Path filePathCreated = Files.createFile(filePath);
        }else{
            System.out.println("File already exists");
        }

        Path source = filePath;
        Path target = Paths.get(filePath.getParent().toString(), "file_rename.txt");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);


    }
}
