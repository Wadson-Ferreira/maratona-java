package academy.devdojo.maratonajava.javacore.VIo.test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;

public class FileTEst01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try {
            boolean isCreated = file.createNewFile();
            System.out.println("Created " + isCreated);
            System.out.println("path " + file.getPath());
            System.out.println("absolute path " + file.getAbsolutePath());
            System.out.println("is directory " + file.isDirectory());
            System.out.println("is file " + file.isFile());
            System.out.println("is hidder " + file.isHidden());
            System.out.println("last modified " + new Date(file.lastModified()));
            System.out.println("last modified " + Instant.ofEpochMilli(file.lastModified()).atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
            boolean exists = file.exists();
            if (exists){
                System.out.println("Deleted " + file.delete());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
