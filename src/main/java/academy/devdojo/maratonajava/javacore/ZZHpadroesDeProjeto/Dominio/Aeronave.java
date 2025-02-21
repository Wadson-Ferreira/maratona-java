package academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio;

import java.util.HashSet;
import java.util.Set;

public final class Aeronave {
    private final Set<String> assentosDisponiveis = new HashSet<>();
    private final String nome;

    public Aeronave(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    {
        assentosDisponiveis.add("1A");
        assentosDisponiveis.add("1B");
    }
    public boolean comprandoAssento (String assento) {
        return assentosDisponiveis.remove(assento);
    }
}
