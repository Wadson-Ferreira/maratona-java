package academy.devdojo.maratonajava.introducao;
/*
  Prática
  Crie variáveis para os campos descritos abaixo entre <> e imprima a seguinte mensagem:
  Eu <nome>, morando no endereço <endereço>, confirmo que recebi o salário de <salario>, na data <data>
*/
public class Aula03TiposPrimitivosExercicio {
    public static void main(String[] args) {
        String nome = "Kirito";
        String endereco = " Rua canuma, Goiânia Goias";
        double salario = 1500.00;
        String dataRecebimentoSalario = "01/04/2024";
        String relatorio =
                "Eu " + nome + " morando no endereço " + endereco + " confirmo que recebi o salário de "
                + salario + ", na data " + dataRecebimentoSalario;

        System.out.println(relatorio);
        System.exit(0);
    }
}
