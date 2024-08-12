package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public class Fileloader implements DataLoader {
    @Override
    public void laod() {
        System.out.println("Carregando dados de um arquivo");
    }
}
