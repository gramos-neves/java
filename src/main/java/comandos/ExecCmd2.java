package comandos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ExecCmd2 {

    public static void main(String[] args) {
        try {

            final List<String> commands = new ArrayList<String>();
            commands.add("cmd.exe");
            commands.add("/C");
            commands.add("cd \"C:\\Program Files (x86)\\Philips Clinical Informatics\\Tasy agent\\bin\" && tasy-agentw.exe tray -autoStart");
            ProcessBuilder pb = new ProcessBuilder(commands);

           // ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\Program Files (x86)\\Philips Clinical Informatics\\Tasy agent\\bin\" && tasy-agentw.exe tray -autoStart");
           // Process pr = builder.start();
           pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
