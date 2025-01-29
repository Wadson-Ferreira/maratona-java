package academy.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Carro;

public interface CarroPredicado {
    //anonimas, funções, conciso
    boolean test(Carro carro);
    //(parametro) -> <expressão>
    //(Car car) -> car.getColor().equals("green")
}
