import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("\n");
        
        int port = 1234;


        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server is listening on port "+port);

            try (Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true)) {


                    String msg = in.readLine();
                    System.out.println("Recived: "+msg);

                    out.println("Hello,Client");
            }

            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
