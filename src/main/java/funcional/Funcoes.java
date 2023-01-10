package funcional;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Funcoes {

    public static void main(String[] args) {
           String[] nomes = {"Joao", "Paulo", "Oliveira", "Santos", "Instrutor", "Java"};
           Integer[] numeros = {1,2,3,4,5};


           String nomesparaImprimirDasStream = Stream.of(nomes)
                                                   .filter(nome -> nome.equals("Joao"))
                                                   .collect(Collectors.joining());

        System.out.printf(nomesparaImprimirDasStream);



    }

    public static  void imprimirTodosNome(String... nomes){
        for(String nome: nomes){
            System.out.printf("Imprimir pelo : " + nome);
        }
    }

}
