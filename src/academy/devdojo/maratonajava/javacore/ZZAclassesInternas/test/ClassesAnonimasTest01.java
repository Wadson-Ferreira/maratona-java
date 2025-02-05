package academy.devdojo.maratonajava.javacore.ZZAclassesInternas.test;

class Animal {
    public void andar(){
        System.out.println("Animal andando");
    }
}

public class ClassesAnonimasTest01 {
    public static void main(String[] args) {
        Animal animal = new Animal(){
            @Override
            public void andar() {
                System.out.println("Animal caminhando nas sombras");
            }
        };
        animal.andar();
    }
}
