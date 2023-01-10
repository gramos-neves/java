package whats;


public class Imagem3 {
	

        public static void main(String[] args) throws Exception {
        	      String path = "C:/Users/guilherme.ramos/Downloads/1_5055622140313731303.pdf";
        	      String url = "https://graph.facebook.com/v15.0/101451992819275/media?messaging_product=WHATSAPP";
        	      String token = "Bearer EAAPo21jnoSsBAHIRiFEs4x2RZAo2lKLJmPJHQW7X5hIm1Ypq3NAijw3qaikhuP4crGZBwJT54uNt5QGu7QB3qqZBZBD1ttn8ZAfw3zwQKOpJzCEJdOx3hfeNDziOlk7ZAGWRBUJT5NzTxZBryfA9FUQFX7J9ofq1CucY40qJ9WBufRQmgZBlhIBN4iL9winQIZCTcKN9QLNnpDiWSSQWmwnLfcOHkKK3aWvUZD";
           
        	     String line =  Imagem.upload(url,path,token);
        	     System.out.println(line);
        }	
        
        
        /*
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
    	}*/
        
    
        
	
}
