package academy.devdojo.maratonajava.javacore.ZZJCrud.test;

import academy.devdojo.maratonajava.javacore.ZZJCrud.servico.AnimeServico;
import academy.devdojo.maratonajava.javacore.ZZJCrud.servico.ProdutorServico;

import java.util.Scanner;

public class CrudTest01 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        while (true){
            menu();
            op = Integer.parseInt(SCANNER.nextLine());
            if (op == 0) break;
            switch (op){
                case 1 -> {
                    menuProdutor();
                    op = Integer.parseInt(SCANNER.nextLine());
                    ProdutorServico.menu(op);
                }
                case 2 -> {
                    menuAnime();
                    op = Integer.parseInt(SCANNER.nextLine());
                    AnimeServico.menu(op);
                }
            }
        }
    }

    private static void menu() {
        System.out.println("digite o número da sua operação");
        System.out.println("1. Produtor");
        System.out.println("2. Anime");
        System.out.println("0. Sair");
    }

    private static void menuProdutor(){
        System.out.println("digite o número da sua operação");
        System.out.println("1. Procurar por produtor");
        System.out.println("2. Deletar produtor");
        System.out.println("3. Salvar um novo produtor");
        System.out.println("4. Atualizar produtor");
        System.out.println("9. Voltar ao menu anterior");
    }

    private static void menuAnime(){
        System.out.println("digite o número da sua operação");
        System.out.println("1. Procurar por um Anime");
        System.out.println("2. Deletar Anime");
        System.out.println("3. Salvar novo Anime");
        System.out.println("4. Atualizar Anime");
        System.out.println("9. Voltar ao menu anterior");
    }
}
