package teste;

import java.time.*;

public class TesteDataHora {

    public static void main(String[] args) {
        LocalDate l = LocalDate.now();
        LocalTime t = LocalTime.now();
        Instant I = Instant.now();
        ZonedDateTime zt = ZonedDateTime.now();

        //periodo


        LocalDate l1 = LocalDate.now();
        LocalDateTime lt = LocalDateTime.now();
        LocalDate l2 = l1.plusWeeks(2).plusDays(1).plusMonths(1);

        Period p = Period.between(l1,l2);

        System.out.println(l);
        System.out.println(t);
        System.out.println(I);
        System.out.println(zt);
        System.out.println(Instant.ofEpochMilli(1560000000000l));
        System.out.println(p);

        Period p1 = Period.ofYears(2);
        //adicionando 2 anos no periodo do tempo trabalha com data
        LocalDate  plus =  l1.plus(p1);
        LocalDateTime  plusL =  lt.plus(p1);
        System.out.println(plus);
        System.out.println(plusL);

        // Diferencia de  horas saber se maior ou menor
        LocalTime ltNow = LocalTime.now();
        LocalTime lti2 = LocalTime.of(10,30,19);

        Duration entre = Duration.between(ltNow,lti2);
        System.out.println(entre);
        System.out.println(entre.isNegative());

        LocalDateTime ltDateNow = LocalDateTime.now();
        LocalDateTime ltdate = LocalDateTime.of(2021,8,03,10,50);
        Duration entre2 = Duration.between(ltDateNow, ltdate);

        System.out.println(entre2.isNegative());

        //System.out.println(Duration.between(ltNow,lti2));

        LocalDate ld = LocalDate.of(1987,2,7);
        LocalDate ldNow = LocalDate.now();
        Period anos = Period.between(ld,ldNow);

       // System.out.println(anos);

    }
}
