package academy.devdojo.maratonajava.javacore.ZZKJunit.dominio;

public class Desenvolvedor extends Funcionario{
    private String mainLinguagem;

    public Desenvolvedor(String id, String mainLinguagem) {
        super(id);
        this.mainLinguagem = mainLinguagem;
    }

    public String getMainLinguagem() {
        return mainLinguagem;
    }
}
