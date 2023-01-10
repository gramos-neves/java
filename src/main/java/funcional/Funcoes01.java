package funcional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Funcoes01 {

    public static void main(String[] args) {
        String[] nomes = {"Joao", "Paulo", "Oliveira", "Santos", "Instrutor", "Java","Paula"};

       List<String> nomesNew = Stream.of(nomes)
                   .filter(resp -> resp.contains("s"))
                   .collect(Collectors.toList());

        System.out.println(nomesNew);
    }

}
