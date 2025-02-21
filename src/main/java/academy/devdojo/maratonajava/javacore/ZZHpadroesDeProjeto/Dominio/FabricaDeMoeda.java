package academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio;

public class FabricaDeMoeda {
    public static Moeda newMoeda(Pais pais) {
        switch (pais) {
            case BRASIL:
                return new Real();
            case USA:
                return new UsDollar();
                default: throw new IllegalArgumentException("Nenhuma moeda encontrada para este país!");
        }
    }
}
