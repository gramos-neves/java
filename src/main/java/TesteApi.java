import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TesteApi {


    public static void main(String[] args) {
             String stockUrlQuery = "cci7nuiad3ie5k93dgkg";
             String tokenUrlQuery = "";

        try {
            URL url = new URL("https://finnhub.io/api/v1/quote?symbol=" + stockUrlQuery + "&token=" + tokenUrlQuery);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            InputStream responseStream = connection.getInputStream();




        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }



    }



}
