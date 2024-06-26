package academy.devdojo.maratonajava.javacore.BIntrudoucaoMetodos.dominio;

public class Funcionario {
    public String nome;
    public int idade;
    public double[] salarios;

    public void imprime(){
        System.out.println(this.nome);
        System.out.println(this.idade);
        if (salarios == null) {
            return;
        }
        for(double salario: this.salarios){
                System.out.print(salario + " ");
        }
        imprimeMediaSalarial();
    }

    public void imprimeMediaSalarial(){
        if (salarios == null) {
            return;
        }
        double media = 0;

        for(double salario: this.salarios){
             media += salario;
        }
        media /= this.salarios.length;

        System.out.println("\nMédia salarial " + media);
    }
}
