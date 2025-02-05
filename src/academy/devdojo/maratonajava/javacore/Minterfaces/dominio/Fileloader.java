package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public class Fileloader implements DataLoader, DataRemover {
    @Override
    public void laod() {
        System.out.println("Carregando dados de um arquivo");
    }

    @Override
    public void remove() {
        System.out.println("Deletendo dados de um arquivo");
    }

    @Override
    public void checkPermission() {
        System.out.println("Checando permissões no arquivo");
    }
}
