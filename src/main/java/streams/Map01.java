package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Map01 {

    public static void main(String[] args) {

        Consumer<String> print = System.out::println;

        List<String>  marcas = Arrays.asList("BMW", "Audi", "Honda");
       // marcas.stream().map(m -> m.toLowerCase()).forEach(print);

        UnaryOperator<String> maiuscula = n -> n.toUpperCase();
        UnaryOperator<String> primeiraLetra = n -> n.charAt(0)  + "";
        UnaryOperator<String> grito = n -> n + "!!!";

        marcas.stream()
               .map(maiuscula)
               .forEach(print);
        System.out.println();
        marcas.stream()
                .map(primeiraLetra)
                .forEach(print);
        System.out.println();
        marcas.stream()
                .map(Utilitarios::grito)
                .forEach(print);



    }
}
