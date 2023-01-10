package fila;

public class Main {

    Fila minhaFila = new Fila();


    public static void main(String[] args) {
        Fila minhaFila = new Fila();

        minhaFila.enqueue(new No("primeiro"));
        minhaFila.enqueue(new No("segundo"));
        minhaFila.enqueue(new No("terceiro"));

        System.out.println(minhaFila.toString());
    }

}
