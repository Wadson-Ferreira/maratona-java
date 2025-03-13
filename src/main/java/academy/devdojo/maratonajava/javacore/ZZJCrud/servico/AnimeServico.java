package academy.devdojo.maratonajava.javacore.ZZJCrud.servico;

import academy.devdojo.maratonajava.javacore.ZZJCrud.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZJCrud.dominio.Produtor;
import academy.devdojo.maratonajava.javacore.ZZJCrud.repositorio.RepositorioAnime;

import java.util.Optional;
import java.util.Scanner;

public class AnimeServico {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) {
            case 1 -> procurarPorNome();
            case 2 -> deletar();
            case 3 -> salvar();
            case 4 -> atualizar();
            case 9 -> {}
            default -> throw new IllegalArgumentException("Opção inválida!");
        }
    }

    private static void procurarPorNome() {
        System.out.println("Digite o nome do anime ou aperte 'Enter' para listar todos: ");
        String nome = SCANNER.nextLine();
        RepositorioAnime.procurarPorNome(nome)
                .forEach(a -> System.out.printf("[Id: %d] - %s - [Episodios: %d] - [Produtor: %s]%n",
                        a.getIdAnime(), a.getNomeAnime(),a.getEpisodios(), a.getProdutor().getNome()));
    }

    private static void deletar() {
        procurarPorNome();
        System.out.println("Digite o ID do anime que deseja deletar: ");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.printf("Tem certeza que deseja deletar o ID %d? S/N? %n", id);
        String confirmacao = SCANNER.nextLine();
        if ("s".equalsIgnoreCase(confirmacao)) RepositorioAnime.deletar(id);
    }

    private static void salvar() {
        System.out.println("Digite o nome do anime que deseja salvar: ");
        String nomeAnime = SCANNER.nextLine();
        System.out.println("Digite o número de episodios do anime que deseja salvar: ");
        int episodios = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Digite o ID do Produtor do anime que deseja salvar: ");
        Integer idProdutor = Integer.parseInt(SCANNER.nextLine());
        Anime anime = Anime.builder()
                .nomeAnime(nomeAnime)
                .episodios(episodios)
                .produtor(Produtor.builder().idProdutor(idProdutor).build())
                .build();
        System.out.printf("Deseja Salvar o Anime: %s ? S/N", anime);
        String confirmacao = SCANNER.nextLine();
        if ("s".equalsIgnoreCase(confirmacao)) RepositorioAnime.salvar(anime);
    }

    private static void atualizar() {
        System.out.println("Escreva o ID do anime que deseja atualizar: ");
        Optional<Anime> animeOptional = RepositorioAnime.procurarPorId(Integer.parseInt(SCANNER.nextLine()));
        if (animeOptional.isEmpty()) {
            System.out.println("Anime não encontrado.");
            return;
        }
        Anime animeBancoDeDados = animeOptional.get();
        System.out.println("Anime encontrado com sucesso: " + animeBancoDeDados);
        System.out.println("Digite o novo nome ou pressione Enter para manter o atual");
        String nome = SCANNER.nextLine();
        nome = nome.isEmpty() ? animeBancoDeDados.getNomeAnime() : nome;

        System.out.println("Digite a quantidade de episodios do Anime: ");
        int episodios = Integer.parseInt(SCANNER.nextLine());


        Anime animeParaAtualizar = Anime.builder()
                .idAnime(animeBancoDeDados.getIdAnime())
                .episodios(episodios)
                .produtor(animeBancoDeDados.getProdutor())
                .nomeAnime(nome)
                .build();
        RepositorioAnime.atualizar(animeParaAtualizar);
    }
}

