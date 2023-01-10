import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class TesteStream {


    public static void main(String[] args) {

        List<String> estudantes = new ArrayList<>();
        estudantes.add("Guilherme") ;
        estudantes.add("Bruna");
        estudantes.add("matheus");
        estudantes.add("bianca");

        //contagem o tamanho
        System.out.println("Contagem : " +  estudantes.stream().count());

        //Retorna o elemento com maior numero de letras
         System.out.println("Maior numero de letras : " + estudantes.stream().max(Comparator.comparingInt(String::length)));

        //retorna o elemento com menor numero de letras
         System.out.println("Menor numero de letras : " + estudantes.stream().min(Comparator.comparingInt(String::length)));


         //retorna os elementos que tem a letra R no nome

          System.out.println("Com letra G no nome: " + estudantes.stream().filter(resp ->
                     resp.toLowerCase().contains("b")).collect(Collectors.toList()) );

         //retorna uma nova coleção, com os nomes concatenados a quantidade de letra de cada nome
        System.out.println("Retorna uam nova coleção com a quantidade de letras: " + estudantes.stream().map(resp -> resp.concat(" - ").concat(String.valueOf(resp.length()))).collect(Collectors.toList())  );
    }

}
