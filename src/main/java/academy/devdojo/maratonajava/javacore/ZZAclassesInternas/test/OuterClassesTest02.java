package academy.devdojo.maratonajava.javacore.ZZAclassesInternas.test;

public class OuterClassesTest02 {
    private String nome = "Midoriya";

    void print (){
        final String sobrenome = "Izuku";
        class LocalClass{
            public void printLocal(){
                System.out.println(nome + " " + sobrenome);
            }
        }
        new LocalClass().printLocal();
    }
    public static void main(String[] args) {
        OuterClassesTest02 outer = new OuterClassesTest02();
        outer.print();
    }
}
