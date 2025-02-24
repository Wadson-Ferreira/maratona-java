package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Produtor;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repositorio.ProdutorRepositorio;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Produtor produtor = Produtor.builder().nome("Studio Deen").build();
        ProdutorRepositorio.salvar(produtor);

    }
}
