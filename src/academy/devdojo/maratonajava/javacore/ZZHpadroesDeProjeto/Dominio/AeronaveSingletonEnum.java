package academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio;

import java.util.HashSet;
import java.util.Set;

public enum AeronaveSingletonEnum {
    INSTANCE;
    private final Set<String> assentosLivres;

    AeronaveSingletonEnum() {
        this.assentosLivres = new HashSet<>();
        this.assentosLivres.add("1A");
        this.assentosLivres.add("1B");
    }

    public boolean comprandoAssennto (String assento) {
        return assentosLivres.remove(assento);
    }
}
