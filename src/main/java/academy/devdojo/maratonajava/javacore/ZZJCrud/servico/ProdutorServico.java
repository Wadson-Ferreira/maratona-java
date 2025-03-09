package academy.devdojo.maratonajava.javacore.ZZJCrud.servico;

import academy.devdojo.maratonajava.javacore.ZZJCrud.dominio.Produtor;
import academy.devdojo.maratonajava.javacore.ZZJCrud.repositorio.RepositorioProdutor;

import java.util.List;
import java.util.Scanner;

public class ProdutorServico {
    private static final Scanner scanner = new Scanner(System.in);

    public static void buildMenu(int op) {
        switch (op){
            case 1:
                procurarPorNome();
                break;
            default:
                throw new IllegalArgumentException("Opção inválida!");
        }
    }

    private static void procurarPorNome() {
        System.out.println("Digite o nome de um produtor ou deixe em branco para listar todos: ");
        String nome = scanner.nextLine();
        List<Produtor> produtores = RepositorioProdutor.procurarPorNome(nome);
        for (int i = 0; i < produtores.size(); i++) {

            System.out.printf("[%d] - %s%n", produtores.get(i).getIdProdutor(), produtores.get(i).getNome());
        }
    }
}
