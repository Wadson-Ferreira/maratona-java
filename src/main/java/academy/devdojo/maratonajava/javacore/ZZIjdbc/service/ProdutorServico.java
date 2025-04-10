package academy.devdojo.maratonajava.javacore.ZZIjdbc.service;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Produtor;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repositorio.ProdutorRepositorio;

import java.util.List;

public class ProdutorServico {

    public static void salvar(Produtor produtor) {
        ProdutorRepositorio.salvar(produtor);
    }

    public static void salvarTransacao (List<Produtor> produtores ) {
        ProdutorRepositorio.salvarTransacao(produtores);
    }


        public static void deletar(Integer id) {
        validandoID(id);
        ProdutorRepositorio.deletar(id);
    }

    public static void atualizar (Produtor produtor) {
        validandoID(produtor.getId());
        ProdutorRepositorio.atualizar(produtor);
    }

    public static void atualizarPreparedStatement (Produtor produtor) {
        validandoID(produtor.getId());
        ProdutorRepositorio.atualizarPreparedStatement(produtor);
    }

    public static List<Produtor> procurarTodos () {
        return ProdutorRepositorio.procurarTodos();
    }

    public static List<Produtor> procurarPorNome (String nome) {
        return ProdutorRepositorio.procurarPorNome(nome);
    }

    public static List<Produtor> procurarPorNomeCallableStatement (String nome) {
        return ProdutorRepositorio.procurarPorNomeCallableStatement(nome);
    }

    public static List<Produtor> procurarPorNomePreparedStatement (String nome) {
        return ProdutorRepositorio.procurarPorNomePreparedStatement(nome);
    }

    public static void metadaDadosProdutor () {
        ProdutorRepositorio.metaDadosDoProdutor();
    }

    public static void driverMetaDadosDoProdutor () {
        ProdutorRepositorio.driverMetaDadosDoProdutor();
    }

    public static void mostrarTypeScrollTrabalhando (){
        ProdutorRepositorio.mostrarTypeScrollTrabalhando();
    }

    public static List<Produtor> procurarPorNomeEAtualizarToUpperCase (String nome) {
        return ProdutorRepositorio.procurarPorNomeEAtualizarToUpperCase(nome);
    }

    public static List<Produtor> procurarPorNomeEInserirNaoEncontrado (String nome) {
        return ProdutorRepositorio.procurarPorNomeEInserirNaoEncontrado(nome);
    }

    public static void procurarPorNomeEDeletar (String nome) {
        ProdutorRepositorio.procurarPorNomeEDeletar(nome);
    }

    private static void validandoID(Integer id) {
        if(id == null || id <= 0){
            throw new IllegalArgumentException("Valor de id invalido, o valor deve ser maior que 0");
        }
    }

}
