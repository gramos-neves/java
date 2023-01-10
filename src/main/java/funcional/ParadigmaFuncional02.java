package funcional;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ParadigmaFuncional02 {

    public static void main(String[] args) {
        int[] valores = {1,2,3,4};

        Arrays.stream(valores)
                .filter(numero -> numero % 2 == 0)
                .map(numero -> numero *2)
                .forEach(numero -> System.out.println(numero));
    }
}
