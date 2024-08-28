package serverSocket;
import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.PrintWriter;


public class Server extends Thread{
    public static void main(String[] args){

        int port =12345;
        
        try {     
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("Server is a Listening on port: "+port);

            while (true) {
                Socket socket = serverSocket.accept();

                

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                
                // Receving Data ............
                String inData = in.readLine();
                System.out.println("Server Receve: "+inData);


                //Send Data ................

                Scanner input = new Scanner(System.in);
                String outData = input.nextLine();
                out.println(outData);
            }

        }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        
         


    }
}
