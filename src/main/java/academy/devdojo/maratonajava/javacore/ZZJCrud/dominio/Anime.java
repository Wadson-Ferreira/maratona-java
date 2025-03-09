package academy.devdojo.maratonajava.javacore.ZZJCrud.dominio;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Anime {
    Integer idAnime;
    String nome;
    int episodios;
    Produtor produtor;
}
