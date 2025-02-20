package academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio.*;

public class DataTransferObjectTest01 {
    public static void main(String[] args) {
        Aeronave aeronave = new Aeronave("777");
        Pais pais = Pais.BRASIL;
        Moeda moeda = FabricaDeMoeda.newMoeda(pais);
        Pessoa pessoa = Pessoa.PessoaBuilder.builder()
                .primeiroNome("Wadson")
                .sobrenome("Ferreira")
                .build();

        RelatorioDto relatorioDto = RelatorioDto.RelatorioDtoBuilder.builder()
                .aeronaveNome(aeronave.getNome())
                .pais(pais)
                .moeda(moeda)
                .pessoaNome(pessoa.getPrimeiroNome())
                .build();

        System.out.println(relatorioDto);
    }
}
