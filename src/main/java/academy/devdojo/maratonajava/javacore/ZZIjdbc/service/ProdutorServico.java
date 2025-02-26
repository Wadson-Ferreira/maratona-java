package academy.devdojo.maratonajava.javacore.ZZIjdbc.service;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Produtor;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repositorio.ProdutorRepositorio;

import java.util.List;

public class ProdutorServico {

    public static void salvar(Produtor produtor) {
        ProdutorRepositorio.salvar(produtor);
    }

    public static void deletar(Integer id) {
        validandoID(id);
        ProdutorRepositorio.deletar(id);
    }

    public static void atualizar (Produtor produtor) {
        validandoID(produtor.getId());
        ProdutorRepositorio.atualizar(produtor);
    }

    public static List<Produtor> procurarTodos () {
        return ProdutorRepositorio.procurarTodos();
    }

    private static void validandoID(Integer id) {
        if(id == null || id <= 0){
            throw new IllegalArgumentException("Valor de id invalido, o valor deve ser maior que 0");
        }
    }
}
