package comparator;

import java.util.Comparator;

public class Serie implements Comparable<Serie> {

      private String nome;
      private String genero;
      private Integer tempoEpisodio;


    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public int compareTo(Serie serie) {
      int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
      if(tempoEpisodio != 0) return tempoEpisodio;


      return this.getGenero().compareTo(serie.getGenero());
    }
}



class ComparatoNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
          int nome = s1.getNome().compareTo(s2.getNome());
          if(nome != 0) return  nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if(genero != 0) return  genero;


        return  Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}


