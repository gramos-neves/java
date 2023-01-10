package colecoes;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class testeSetTreet {

    public static void main(String[] args) {
        Set<String> cursos = new HashSet<>();
        cursos.add("PHP");
        cursos.add("Java");
        cursos.add("PL/SQL");
        cursos.add("Adobe");
        cursos.add("PHP");

        Set<String> ord = new TreeSet<>(cursos);

        System.out.println("Sem ordenação: "+cursos);
        System.out.println("Com ordenação: "+ord);


    }
}
