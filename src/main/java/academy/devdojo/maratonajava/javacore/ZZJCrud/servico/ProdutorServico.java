package academy.devdojo.maratonajava.javacore.ZZJCrud.servico;

import academy.devdojo.maratonajava.javacore.ZZJCrud.dominio.Produtor;
import academy.devdojo.maratonajava.javacore.ZZJCrud.repositorio.RepositorioProdutor;

import javax.swing.*;
import java.util.Optional;
import java.util.Scanner;

public class ProdutorServico {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) {
            case 1 -> procurarPorNome();
            case 2 -> deletar();
            case 3 -> salvar();
            case 4 -> atualizar();
            default -> throw new IllegalArgumentException("Opção inválida!");
        }
    }

    private static void procurarPorNome() {
        System.out.println("Digite o nome do produtor ou aperte 'Enter' para listar todos: ");
        String nome = SCANNER.nextLine();
        RepositorioProdutor.procurarPorNome(nome)
                .forEach(p -> System.out.printf("[Id: %d] - %s%n", p.getIdProdutor(), p.getNome()));
    }

    private static void deletar() {
        procurarPorNome();
        System.out.println("Digite o ID do produtor que deseja deletar: ");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.printf("Tem certeza que deseja deletar o ID %d? S/N? %n", id);
        String confirmacao = SCANNER.nextLine();
        if ("s".equalsIgnoreCase(confirmacao)) RepositorioProdutor.deletar(id);
    }

    private static void salvar() {
        System.out.println("Digite o nome do produtor que deseja salvar: ");
        String nome = SCANNER.nextLine();
        Produtor produtor = Produtor.builder().nome(nome).build();
        int confirmacao = JOptionPane
                .showConfirmDialog(null, "Deseja Salvar o Produtor: %s?"
                        .formatted(produtor.getNome()), "Salvar", JOptionPane.YES_NO_OPTION);
        if (confirmacao == 0) RepositorioProdutor.salvar(produtor);
    }

    private static void atualizar(){
        System.out.println("Escreva o ID do produtor que deseja atualizar: ");
        Optional<Produtor> produtorOptional = RepositorioProdutor.procurarPorId(Integer.parseInt(SCANNER.nextLine()));
        if (produtorOptional.isEmpty()){
            System.out.println("Produtor não encontrado.");
            return;
        }
        Produtor produtorBancoDeDados = produtorOptional.get();
        System.out.println("Produtor encontrado com sucesso: " + produtorBancoDeDados);
        System.out.println("Digite o novo nome ou pressione Enter para manter o atual");
        String nome = SCANNER.nextLine();
        nome = nome.isEmpty() ? produtorBancoDeDados.getNome() : nome;

        Produtor produtorParaAtualizar = Produtor.builder()
                .idProdutor(produtorBancoDeDados.getIdProdutor())
                .nome(nome)
                .build();

        RepositorioProdutor.atualizar(produtorParaAtualizar);


    }
}

