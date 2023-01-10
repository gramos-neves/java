import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TesteList {

    public static void main(String[] args) {
        List<String>  nomes = new ArrayList<>();
        nomes.add("Guilherme") ;
        nomes.add("Bruna");
        nomes.add("matheus");
        nomes.add("bianca");

        String nome = nomes.get(0);
        System.out.println(nome);
        System.out.println("");
        for(String nome1: nomes){
           System.out.println(nome1);
        }

        Iterator<String> iterator = nomes.iterator();
        System.out.println("");
        while (iterator.hasNext()){

            System.out.println(iterator.next());
        }

    }


}
