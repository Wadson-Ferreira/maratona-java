package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherTest01 {
    public static void main(String[] args) {
        Path path1 = Paths.get("Arquivos/SubPasta1/SubSubPasta1/subsubarquivo1.txt");
        Path path2 = Paths.get("Arquivos/SubPasta1/SubSubPasta1/subsubarquivo1.bkb");
        Path path3 = Paths.get("Arquivos/SubPasta1/SubSubPasta1/subsubarquivo1.java");
        matches(path2, "glob:*.bkb");
        matches(path2, "glob:**.bkb");
        matches(path2, "glob:**/*.bkb");
        matches(path1, "glob:**/*.{bkb,txt,java}");
        matches(path2, "glob:**/*.{bkb,txt,java}");
        matches(path3, "glob:**/*.{bkb,txt,java}");
        matches(path3, "glob:**/*.???");
        matches(path1, "glob:**/subsubarquivo1.???");
    }

    private static void matches (Path path, String glob)  {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
    }
}
