package teste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class testeWrite {

    public static void main(String[] args) {
        try {
            BufferedWriter buffeWrite = new BufferedWriter(new FileWriter("text.txt"));
            String linha = "";
            Scanner in = new Scanner(System.in);
            System.out.println("Escrevar");
            linha = in.nextLine();
            buffeWrite.append(linha + "\n");
            buffeWrite.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
