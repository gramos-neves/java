package file;

import java.io.*;
import java.util.Base64;

public class arquivos {

    public static void main(String[] args) throws IOException {

        final int BUFFER_SIZE = 3 * 1024;



        try {
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Temp\\6cdd6fb2-c7ed-4717-8dc6-82c54d54da2a.jpg"));
            Base64.Encoder encoder = Base64.getEncoder();



            String readline = bf.readLine();

            System.out.println( encoder.encode(readline.getBytes()));


       /*
            while(readline != null){
                System.out.println(readline);
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
