package whats;

import java.net.*;
import java.io.*;



public class Imagem6 {
	

        public static void main(String[] args) throws Exception {
                 upload();
        }	
        
        
        public static void dowload() throws IOException {
    		try {
    		    URL myURL = new URL("http://localhost:8091/teste?messaging_product=WHATSAPP");

    		    BufferedReader in = new BufferedReader(new InputStreamReader(myURL.openStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
                in.close();
    		} 
    		catch (IOException e) {
    		    // exception handler code here
    		    // ...
    		}
    	}
        
        
        public static void upload() throws IOException {
    	    URL myURL = new URL("https://graph.facebook.com/v15.0/101451992819275/media?messaging_product=WHATSAPP");
    	   // URL myURL = new URL("http://localhost:8091/teste?messaging_product=WHATSAPP");

    	    File binaryFile = new File("C:/Users/guilherme.ramos/Downloads/1_5055622140313731303.pdf");
    	   
    	    String boundary = Long.toHexString(System.currentTimeMillis());
    		// Line separator required by multipart/form-data.
    	    String CRLF     = "\r\n";
    		String charset  = "UTF-8";
    	    
    	    URLConnection connection = myURL.openConnection();
    	    connection.setDoOutput(true);
    	    connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
    	    connection.setRequestProperty("Authorization", "Bearer EAAPo21jnoSsBAHIRiFEs4x2RZAo2lKLJmPJHQW7X5hIm1Ypq3NAijw3qaikhuP4crGZBwJT54uNt5QGu7QB3qqZBZBD1ttn8ZAfw3zwQKOpJzCEJdOx3hfeNDziOlk7ZAGWRBUJT5NzTxZBryfA9FUQFX7J9ofq1CucY40qJ9WBufRQmgZBlhIBN4iL9winQIZCTcKN9QLNnpDiWSSQWmwnLfcOHkKK3aWvUZD");

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
            while ( line != null ) {  
                System.out.println(line);  
                line = br.readLine();  
            }  
            br.close();
    	}
        
	
}
