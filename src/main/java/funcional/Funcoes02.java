package funcional;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class Funcoes02 {


    public static void main(String[] args) {
        BigDecimal[] numeros = {BigDecimal.valueOf(20.30),BigDecimal.valueOf(10.30)};


       BigDecimal valor = Stream.of(numeros)
                 .map(resp -> resp)
                 .reduce((x,y) -> x.add(y)).get();

        System.out.printf("Valor :" + valor);
    }
}
