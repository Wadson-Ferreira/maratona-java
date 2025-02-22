package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Produtor;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repositorio.ProdutorRepositorio;

public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Produtor produtor = Produtor.ProdutorBuilder.builder().nome("NHK").build();
        ProdutorRepositorio.salvar(produtor);
    }
}
