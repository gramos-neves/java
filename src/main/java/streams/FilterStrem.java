package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterStrem {

    public static void main(String[] args) {
        Aluno a1 = new Aluno("Ana", 7.8);
        Aluno a2 = new Aluno("Bruna", 8.8);
        Aluno a3 = new Aluno("Rafaela", 3.8);
        Aluno a4 = new Aluno("Gui", 9.8);
        Aluno a5 = new Aluno("Rebeca", 5.0);
        Aluno a6 = new Aluno("Pedro", 4.8);

        List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4,a5,a6);


        Predicate<Aluno> aprovado = a -> a.nota >= 7;

        Function<Aluno, String> saudacaoAprovado =
                 a -> "Parabens " + a.nome + "! Você foi aprovado(a)!";

        alunos.stream()
                .filter(aprovado)
                .map(saudacaoAprovado)
                .forEach(System.out::println);

    }
}
