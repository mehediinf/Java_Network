package serverSocket;
import java.net.URLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class UrlConnection {
    public static void main(String[] args) throws IOException {
        
        try {
            URL url = new URL("https://github.com/mehediinf/Java_Network/blob/main/serverSocket/UDPClient.java");

            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;

            while ((inputLine=bufferedReader.readLine())!=null) {
                System.out.println(inputLine);
                
            }

            bufferedReader.close();

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
