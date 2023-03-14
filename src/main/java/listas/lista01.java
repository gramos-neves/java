package listas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lista01 {

    public static void main(String[] args) {

        List<Double> notas = new ArrayList<>();

        notas.add(7.0);
        notas.add(6.0);
        notas.add(5.0);
        notas.add(4.0);

        System.out.println(notas.indexOf(5d));

        System.out.println(notas.contains(9d));

        System.out.println(notas.toString());

        System.out.println(notas.set(notas.indexOf(7d),9d));

        System.out.println(notas.toString());

        Iterator<Double> iterator = notas.iterator();
        Double d = 0d;
        while(iterator.hasNext()){
            Double next = iterator.next();
            d +=  next;
        }

        System.out.println(d);

    }

}
