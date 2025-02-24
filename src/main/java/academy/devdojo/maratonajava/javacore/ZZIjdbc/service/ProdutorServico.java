package academy.devdojo.maratonajava.javacore.ZZIjdbc.service;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Produtor;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repositorio.ProdutorRepositorio;

public class ProdutorServico {

    public static void salvar(Produtor produtor) {
        ProdutorRepositorio.salvar(produtor);
    }

    public static void deletar(int id) {
        if(id <= 0){
            throw new IllegalArgumentException("Valor de id invalido, o valor deve ser maior que 0");
        }
        ProdutorRepositorio.deletar(id);
    }
}
