package academy.devdojo.maratonajava.javacore.Minterfaces.Test;


import academy.devdojo.maratonajava.javacore.Minterfaces.dominio.DataLoader;
import academy.devdojo.maratonajava.javacore.Minterfaces.dominio.DatabaseLoader;
import academy.devdojo.maratonajava.javacore.Minterfaces.dominio.Fileloader;

public class DataLoaderTest01 {
    public static void main(String[] args) {
        DatabaseLoader databaseLoader = new DatabaseLoader();
        Fileloader fileloader = new Fileloader();
        databaseLoader.laod();
        fileloader.laod();

        databaseLoader.remove();
        fileloader.remove();

        databaseLoader.checkPermission();
        fileloader.checkPermission();

        DataLoader.retrieveMaxDataSize();
        DatabaseLoader.retrieveMaxDataSize();
    }
}
