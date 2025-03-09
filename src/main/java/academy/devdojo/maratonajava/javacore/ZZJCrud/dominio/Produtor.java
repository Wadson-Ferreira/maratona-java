package academy.devdojo.maratonajava.javacore.ZZJCrud.dominio;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Produtor {
    Integer idProdutor;
    String nome;
}
