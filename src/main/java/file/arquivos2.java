package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class arquivos2 {

    public static void main(String[] args) throws IOException {

        final int BUFFER_SIZE = 3 * 1024;

        String imagePath = "C:\\Temp\\6cdd6fb2-c7ed-4717-8dc6-82c54d54da2a.jpg";
        Path pathToImage = Paths.get(imagePath);


        byte[] imageBytes = Files.readAllBytes(pathToImage);

        String base64Encode = Base64.getEncoder().encodeToString(imageBytes);
        System.out.println(base64Encode);


       //     BufferedReader bf = new BufferedReader(new FileReader("C:\\Temp\\6cdd6fb2-c7ed-4717-8dc6-82c54d54da2a.jpg"));

    }
}
