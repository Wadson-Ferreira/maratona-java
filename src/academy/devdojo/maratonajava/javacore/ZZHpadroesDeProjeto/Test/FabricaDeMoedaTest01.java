package academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio.FabricaDeMoeda;
import academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio.Moeda;
import academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio.Pais;

public class FabricaDeMoedaTest01 {
    public static void main(String[] args) {
        Moeda moeda = FabricaDeMoeda.newMoeda(Pais.BRASIL);
        System.out.println(moeda.getSimbolo());
    }
}
