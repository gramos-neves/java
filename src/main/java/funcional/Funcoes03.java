package funcional;

import java.util.ArrayList;
import java.util.List;

public class Funcoes03 {


    public static void main(String[] args) {

        List<Double> valores = new ArrayList<>();
        valores.add(20.5);
        valores.add(10.5);
        valores.add(10.5);

        Double resp =  valores.stream()
                            .reduce(0.0, Double::sum);


        System.out.printf("valor : " + resp);

    }

}
