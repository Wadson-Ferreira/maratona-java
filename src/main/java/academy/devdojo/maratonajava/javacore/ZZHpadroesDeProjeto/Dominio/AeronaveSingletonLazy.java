package academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio;

import java.util.HashSet;
import java.util.Set;

public final class AeronaveSingletonLazy {
    private static AeronaveSingletonLazy INSTANCE;
    private final Set<String> assentosDisponiveis = new HashSet<>();
    private final String nome;

    private AeronaveSingletonLazy(String nome) {
        this.nome = nome;
    }

    {
        assentosDisponiveis.add("1A");
        assentosDisponiveis.add("1B");
    }

    public static AeronaveSingletonLazy getInstance() {
        if (INSTANCE == null) {
            synchronized (AeronaveSingletonLazy.class) {
                if (INSTANCE == null) {
                INSTANCE = new AeronaveSingletonLazy("Boing-747");
                }
            }
        }
        return INSTANCE;
    }

    public boolean comprandoAssento(String assento) {
        return assentosDisponiveis.remove(assento);
    }
}
