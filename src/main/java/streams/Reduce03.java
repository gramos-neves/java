package streams;

import java.util.Arrays;
import java.util.List;
import  java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Reduce03 {


    public static void main(String[] args) {
        Aluno a1 = new Aluno("Ana", 7.1);
        Aluno a2 = new Aluno("Ana", 5.1);
        Aluno a3 = new Aluno("Ana", 8.1);
        Aluno a4 = new Aluno("Ana", 9.1);
        Aluno a5 = new Aluno("Ana", 3.1);

        List<Aluno>  alunos = Arrays.asList(a1,a2,a3,a4);
        Predicate<Aluno> aprovado = a -> a.nota >= 7;
        Function<Aluno, Double> apenasNotas = a -> a.nota;

        BiFunction<Media,Double,Media> calculaMedia =
                (media, nota) -> media.adicionar(nota);

        BinaryOperator<Media> combinarMedia =
                (m1,m2) -> Media.combina(m1,m2);


        Media media = alunos.stream()
                .filter(aprovado)
                .map(apenasNotas)
                .reduce(new Media(), calculaMedia, combinarMedia);

        System.out.printf( " Media :" + media.getValor());

    }
}
