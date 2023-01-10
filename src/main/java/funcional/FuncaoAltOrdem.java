package funcional;

public class FuncaoAltOrdem {

    public static void main(String[] args) {
        Calcular soma = (a,b) -> a + b;
        System.out.printf("Soma: " + executarOperacao(soma,1,3));
    }

    public static int executarOperacao(Calcular calcular, int a, int b){
          return  calcular.calcular(a,b);
    }


}

interface  Calcular{
    public int calcular(int a, int b);
}