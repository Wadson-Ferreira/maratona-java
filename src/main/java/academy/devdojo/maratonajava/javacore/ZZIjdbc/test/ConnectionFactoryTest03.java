package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Produtor;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProdutorServico;

import java.util.List;

public class ConnectionFactoryTest03 {
    public static void main(String[] args) {
        Produtor produtor1 = Produtor.builder().nome("Toei Animation").build();
        Produtor produtor2 = Produtor.builder().nome("White Fox").build();
        Produtor produtor3 = Produtor.builder().nome("Studio Ghibli").build();

        ProdutorServico.salvarTransacao(List.of(produtor1, produtor2, produtor3));
    }
}
