package funcional;

public class Recursividade {

    public static void main(String[] args) {
        System.out.printf("fatorial  : " + fatorial(5));

    }

     public  static  double fatorial(double valor){
        return  fatorialComTailCall(valor, 1);
     }


      public  static  double fatorialComTailCall(double valor, double numero){
           if(valor == 0){
               return numero;
           }
           return fatorialComTailCall(valor -1, numero * valor);
      }

}
