package academy.devdojo.maratonajava.javacore.ZZJCrud.test;

import academy.devdojo.maratonajava.javacore.ZZJCrud.servico.ProdutorServico;

import java.util.Scanner;

public class CrudTest01 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        while (true){
            menuProdutor();
            op = Integer.parseInt(scanner.nextLine());
            if (op == 0) break;
            ProdutorServico.buildMenu(op);
        }
    }

    private static void menuProdutor(){
        System.out.println("digite o número da sua operação");
        System.out.println("1. Procurar por produtor");
        System.out.println("0. Para sair");
    }
}
