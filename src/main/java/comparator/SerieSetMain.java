package comparator;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SerieSetMain {

    public static void main(String[] args) {

        Set<Serie> minhasSeries = new HashSet<Serie>(){{
             add(new Serie("got","fantasia",60));
            add(new Serie("dark","drama",12));
            add(new Serie("that ","comedia",60));
        }};

        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries);
        System.out.println(minhasSeries2);

        Set<Serie> minhasSeries3  = new TreeSet<>(new ComparatoNomeGeneroTempoEpisodio());

    }
}
