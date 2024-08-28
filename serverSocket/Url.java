package serverSocket;
import java.net.MalformedURLException;
import java.net.URL;
public class Url {
    public static void main(String[] args) {
        
        try {
            URL url = new URL("https://mehedi.com/mehediinf/Java_Network");

            System.out.println("Protocol: "+url.getProtocol());

            System.out.println("Host: "+url.getHost());
            System.out.println("Port: "+url.getPort());
            System.out.println("Path: "+url.getPath());
            System.out.println("Query: "+url.getQuery());
            System.out.println("File: "+url.getFile());


        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
