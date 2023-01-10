package teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class teste {


    public static void main(String[] args) {
        SimpleDateFormat form2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");

        SimpleDateFormat form3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String data = "2022/03/14 12:08:07.0 America/Sao_Paulo";

      //  Date x = new Date("2022-03-14 12:08:07.0 America/Sao_Paulo");

        Date d = null;
        try {
            d = form3.parse(data);
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
