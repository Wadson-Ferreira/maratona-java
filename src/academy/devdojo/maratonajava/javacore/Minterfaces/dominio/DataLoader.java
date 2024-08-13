package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public interface DataLoader {
    void laod();
    default void checkPermission(){
        System.out.println("Fazendo checagem de permissões");
    }
}
