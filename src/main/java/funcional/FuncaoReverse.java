package funcional;


import java.util.function.Function;
import java.util.function.Predicate;

public class FuncaoReverse {

    public static void main(String[] args) {
        Function<String,String> retornaNaNomeAoContario = texto -> new StringBuilder(texto).reverse().toString();
        Function<String, Integer> ConverteStringParaInteiro = string -> Integer.valueOf(string);
        Predicate<String> estaVazio = valor -> valor.isEmpty();
        Predicate<String> estaVazio2 = String::isEmpty;
        System.out.printf(retornaNaNomeAoContario.apply("Guilherme"));
    }
}
