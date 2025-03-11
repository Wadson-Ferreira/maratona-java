package academy.devdojo.maratonajava.javacore.ZZJCrud.servico;

import academy.devdojo.maratonajava.javacore.ZZJCrud.dominio.Produtor;
import academy.devdojo.maratonajava.javacore.ZZJCrud.repositorio.RepositorioProdutor;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class ProdutorServico {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) {
            case 1:
                procurarPorNome();
                break;
            case 2:
                deletar();
                break;
            default:
                throw new IllegalArgumentException("Opção inválida!");
        }
    }

    private static void procurarPorNome() {
        System.out.println("Digite o nome do produtor ou aperte 'Enter' para listar todos: ");
        String nome = SCANNER.nextLine();
        List<Produtor> produtores = RepositorioProdutor.procurarPorNome(nome);
        for (int i = 0; i < produtores.size(); i++) {
            Produtor produtor = produtores.get(i);
            System.out.printf("[%d] - ID: %d %s%n", i, produtor.getIdProdutor(), produtor.getNome());
        }
    }

    private static void deletar() {
        procurarPorNome();
        System.out.println("Digite o ID do produtor que deseja deletar: ");
        int id = Integer.parseInt(SCANNER.nextLine());
        int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar?");
        if (confirmacao == 0) RepositorioProdutor.deletar(id);
    }
}

