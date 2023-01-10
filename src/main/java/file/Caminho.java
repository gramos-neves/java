package file;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Caminho {


    public static void main(String[] args) {

      //  Path path = Paths.get("C:\\Temp\\94329784-d7a0-46b6-a92d-890792100a87.jpg");

        // Create a file object
        File f = new File("C:\\Temp\\94329784-d7a0-46b6-a92d-890792100a87.jpg");

        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();

        // Display the file path of the file object
        // and also the file path of absolute file
        System.out.println("Original  path: "
                + f.getPath());
        System.out.println("Absolute  path: "
                + absolute);



    }


}
