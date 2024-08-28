package serverSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread{
    public static void main(String[] args){
       
       
        String serverAddress = "127.0.0.1";
        int port = 12345;


        try {
        while (true) {
    
            try (Socket socket = new Socket(serverAddress,port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

                
                    Scanner input = new Scanner(System.in);
                    String outData = input.nextLine();
                    out.println(outData);
                    

                    String msg = in.readLine();
                    System.out.println("Client Recive: "+msg);


                    
                }
            }
        
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       

    }
}
