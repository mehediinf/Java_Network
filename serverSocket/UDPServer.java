package serverSocket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;
import java.io.IOException;
import java.net.DatagramPacket;
public class UDPServer extends Thread{
    public static void main(String[] args) throws IOException, InterruptedException {
        try {

            while (true) {
                //Data Reciving ................

            try (DatagramSocket socket = new DatagramSocket(4545)) {
                byte[] reciveBuffer =new byte[1024];

                DatagramPacket reciveDataPacket = new DatagramPacket(reciveBuffer,reciveBuffer.length);
                socket.receive(reciveDataPacket);
                String msg =new String(reciveDataPacket.getData(),0,reciveDataPacket.getLength());
                
                System.out.println("Recive: "+msg);


                sleep(500);

                //Send Data ... ..............
                Scanner in = new Scanner(System.in);
                System.out.print("Send: ");
                    String sendString = in.nextLine();
                    byte[] sendBuffer = sendString.getBytes();
                    DatagramPacket senDatagramPacket = new DatagramPacket(sendBuffer, 0,sendBuffer.length,reciveDataPacket.getAddress(),reciveDataPacket.getPort());
                    
                    socket.send(senDatagramPacket);
                }
            }

            


        

        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
