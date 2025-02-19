package academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio;

public interface Moeda {
    String getSimbolo();
}

class Real implements Moeda {
    @Override
    public String getSimbolo() {
        return "R$";
    }
}

class UsDollar implements Moeda {
    @Override
    public String getSimbolo() {
        return "$";
    }
}