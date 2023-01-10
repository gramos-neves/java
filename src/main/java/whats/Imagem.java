package whats;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class Imagem {
	
    public static String upload(String url,String path, String token) throws IOException {
	    URL myURL = new URL(url);
	   // URL myURL = new URL("http://localhost:8091/teste?messaging_product=WHATSAPP");

	    File binaryFile = new File(path);
	   
	    String boundary = Long.toHexString(System.currentTimeMillis());
		// Line separator required by multipart/form-data.
	    String CRLF     = "\r\n";
		String charset  = "UTF-8";
	    
	    URLConnection connection = myURL.openConnection();
	    connection.setDoOutput(true);
	    connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
	    connection.setRequestProperty("Authorization", token);

	    PrintWriter writer = null;
	    try {
	        OutputStream output = connection.getOutputStream();
	        writer = new PrintWriter(new OutputStreamWriter(output, charset), true); // true = autoFlush, important!
	
	        // Send binary file.
	        System.out.println("binaryFile: "+binaryFile.getName());
	        System.out.println("Content-Type: "+URLConnection.guessContentTypeFromName(binaryFile.getName()));
	        writer.append("--" + boundary).append(CRLF);
	        writer.append("Content-Disposition: form-data; name=\"file\"; filename=\""+ binaryFile.getName() + "\"").append(CRLF);
	        writer.append("Content-Type: "+ URLConnection.guessContentTypeFromName(binaryFile.getName())).append(CRLF);
	        writer.append("Content-Transfer-Encoding: binary").append(CRLF);
	        writer.append(CRLF).flush();
	        InputStream input = new FileInputStream(binaryFile);
	        try {
	            byte[] buffer = new byte[1024];
	            for (int length = 0; (length = input.read(buffer)) > 0;) {
	                output.write(buffer, 0, length);
	            }
	            output.flush(); // Important! Output cannot be closed. Close of writer will close output as well.
	        } finally {
	            try { input.close(); } catch (IOException logOrIgnore) {}
	        }
	        writer.append(CRLF).flush(); // CRLF is important! It indicates end of binary boundary.

	        // End of multipart/form-data.
	        System.out.println("--" + boundary + "--" + CRLF);
	        writer.append("--" + boundary + "--").append(CRLF);
	    } finally {
	        if (writer != null) writer.close();
	    }

	    //Retrieve response
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));  
        String line = br.readLine();  
        br.close();
        return line;
        /*
        while ( line != null ) {  
            System.out.println(line);  
            line = br.readLine();  
        }  
        br.close();
        */
	}

}
