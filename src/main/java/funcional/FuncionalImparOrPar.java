package funcional;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class FuncionalImparOrPar {

    public static void main(String[] args) {
        Function<Integer, String> parOrImpar = numero -> numero % 2 == 0 ? "Par" : "Impar";

        System.out.println(parOrImpar.apply(23));


        BinaryOperator<Double> media = (n1, n2) -> (n1 +n2) / 2;
        System.out.println(media.apply(9.8,5.7));

        BiFunction<Double, Double, String> resultdo = (n1, n2) -> {
            double notafinal = ( n1 + n2) / 2;
            return notafinal >= 7 ? "Aprovado" : "Reprovado";
        };

        System.out.println(resultdo.apply(9.7, 5.1));

    }
}
