package academy.devdojo.maratonajava.javacore.ZZAclassesInternas.test;

public class OuterClassesTest03 {
    private String nome = "Wadson";
    static class Nested {
        private String sobrenome = "Ferreira";
        void print(){
            System.out.println(new OuterClassesTest03().nome + " " + sobrenome);
        }
    }
    public static void main(String[] args) {
       new Nested().print();
    }
}
