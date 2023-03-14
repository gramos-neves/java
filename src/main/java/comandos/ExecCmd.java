package comandos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class ExecCmd {

    public static void main(String[] args) {
        //String pasta = "C:\\Program Files (x86)\\Philips Clinical Informatics\\Tasy agent\\bin\\";

        String pasta = "C:/Users/guilherme.ramos/Documents/Nova pasta/";
        String programa = "notepad++.exe"; // substitua pelo nome do seu programa
        try {
            ProcessBuilder builder = new ProcessBuilder(programa);
            builder.directory(new File(pasta));
            builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
