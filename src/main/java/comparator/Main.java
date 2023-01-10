package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Gato> meusGatos = new ArrayList<Gato>(){{
             add(new Gato("jon", 18, "preto" ));
            add(new Gato("Simba", 6, "tigrado" ));
            add(new Gato("jo", 12, "amarelo" ));
        }};

        System.out.println(meusGatos);
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        Collections.sort(meusGatos, new ComparatorIdade());
        System.out.println(meusGatos);

        Collections.sort(meusGatos, new ComparatorCor());
        System.out.println(meusGatos);



    }
}
