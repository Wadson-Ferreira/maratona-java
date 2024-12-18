package academy.devdojo.maratonajava.javacore.VIo.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//File
//FileWriter
//FileReader
//BufferedWriter
//BufferedReader
public class FileWriter01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("Hello World\n Ao adicionar o append ele ira apenas " +
                    "adicionar mais texto ao arquivo\n Sem o append ele " +
                    "excluir o arquivo e cria um novo");
            fw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
