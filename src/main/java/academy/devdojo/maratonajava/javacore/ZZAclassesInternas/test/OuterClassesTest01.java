package academy.devdojo.maratonajava.javacore.ZZAclassesInternas.test;

public class OuterClassesTest01 {
    private String nome = "Monkey D. Luffy";

    class Inner {
        public void printOuterClassAttribute(){
            System.out.println(nome);
            System.out.println(this);
            System.out.println(OuterClassesTest01.this);
        }
    }
    public static void main(String[] args) {
        OuterClassesTest01 outerClass = new OuterClassesTest01();
        Inner inner = outerClass.new Inner();
        Inner inner2 = new OuterClassesTest01().new Inner();
        inner.printOuterClassAttribute();
        inner2.printOuterClassAttribute();
    }
}
