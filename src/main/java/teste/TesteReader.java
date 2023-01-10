package teste;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TesteReader {

    public static void main(String[] args) {

        FileReader reader;

        try {
            reader = new FileReader("input2.txt");
            BufferedReader buffer = new BufferedReader(reader,16384);

            String line = "";
            long initialTime = System.currentTimeMillis();
            while (true){
                try {
                    line = buffer.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(line == null)
                    break;

                System.out.println(line);
                System.out.println("Time taken : "
                        + (System.currentTimeMillis()
                        - initialTime));

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
