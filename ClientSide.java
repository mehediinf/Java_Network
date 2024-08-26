import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSide {

    public static void main(String[] args) {
        System.out.println("\n");
        
        String serverAddress = "127.0.0.1";
        int port = 1234;

       try (Socket socket = new Socket(serverAddress,port);
       PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
       BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
           
           out.println("Hello,Server");

           String response = in.readLine();
           System.out.println("Server says: "+response);
       

        
       } catch (Exception e) {
        // TODO: handle exception
       } 


    }
}