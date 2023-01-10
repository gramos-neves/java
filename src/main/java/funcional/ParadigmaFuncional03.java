package funcional;

public class ParadigmaFuncional03 {

    public static void main(String[] args) {

        Funcão1 gerarUmSaida = valor -> valor;

        System.out.printf(" saida : " + gerarUmSaida.gerar("Saida de uma função"));

    }
}


@FunctionalInterface
interface  Funcão1 {
    String gerar(String valor);
}
