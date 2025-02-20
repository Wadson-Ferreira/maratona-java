package academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio;

import java.util.HashSet;
import java.util.Set;

public final class AeronaveSingletonEager {
    private static final AeronaveSingletonEager INSTANCE = new AeronaveSingletonEager("787-900");
    private final Set<String> assentosDisponiveis = new HashSet<>();
    private final String nome;

    private AeronaveSingletonEager(String nome) {
        this.nome = nome;
    }

    {
        assentosDisponiveis.add("1A");
        assentosDisponiveis.add("1B");
    }

    public static AeronaveSingletonEager getInstance() {
        return INSTANCE;
    }

    public boolean comprandoAssento (String assento) {
        return assentosDisponiveis.remove(assento);
    }
}
