package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais {
    public static void main(String[] args) {
        int idade = 16;
        boolean isAutorizadoComprarBebida = idade >= 18;
        // !
        if(isAutorizadoComprarBebida){
            System.out.println("Autorizado a comprar bebida alcólica");
        }

        if(!isAutorizadoComprarBebida){
            System.out.println("Não autorizado a comprar bebida alcólica");
        }

        if(isAutorizadoComprarBebida == false){
           System.out.println("Não autorizado a comprar bebida alcólica");
        }

        System.out.println("Fora do if");
    }
}
