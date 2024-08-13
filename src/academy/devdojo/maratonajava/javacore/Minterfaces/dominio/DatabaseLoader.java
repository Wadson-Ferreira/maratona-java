package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

import java.sql.SQLOutput;

public class DatabaseLoader implements DataLoader, DataRemover{
    @Override
    public void laod() {
        System.out.println("Carregando dados do banco de dados");
    }

    @Override
    public void remove() {
        System.out.println("Removendo dados do banco de dados");
    }

    @Override
    public void checkPermission() {
        System.out.println("Chegando permissões no banco de dados");
    }
}
