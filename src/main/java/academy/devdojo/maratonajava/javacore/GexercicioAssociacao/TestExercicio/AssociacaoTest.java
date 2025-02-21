package academy.devdojo.maratonajava.javacore.GexercicioAssociacao.TestExercicio;

import academy.devdojo.maratonajava.javacore.GexercicioAssociacao.dominio.Aluno;
import academy.devdojo.maratonajava.javacore.GexercicioAssociacao.dominio.Local;
import academy.devdojo.maratonajava.javacore.GexercicioAssociacao.dominio.Professor;
import academy.devdojo.maratonajava.javacore.GexercicioAssociacao.dominio.Seminario;

public class AssociacaoTest {
    public static void main(String[] args) {
        Local local = new Local("Rua das laranjeiras");
        Aluno aluno = new Aluno("Luffy", 17);
        Professor professor = new Professor("Barba Branca", "Pirata");
        Aluno[] alunosParaSeminario = {aluno};
        Seminario seminario = new Seminario("Onde achar One piece",
                alunosParaSeminario, local);
        Seminario[] seminariosDisponiveis = {seminario};

        professor.setSeminarios(seminariosDisponiveis);
        professor.imprime();
    }
}
