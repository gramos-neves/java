package threads;

public class Threads01 {

    BarraCarregamento barraCarregamento = new BarraCarregamento();


}


class GerarPDF implements  Runnable{

    @Override
    public void run() {
        System.out.printf("Loading...");
    }
}

class BarraCarregamento implements  Runnable{

    @Override
    public void run() {

    }
}