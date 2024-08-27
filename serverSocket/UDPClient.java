package serverSocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient extends Thread{
    public static void main(String[] args) {

        

        try {
            try (DatagramSocket socket = new DatagramSocket()) {
              
                while (true) {
                    
                

                  //Data Sending .................. 
                    Scanner in = new Scanner(System.in);
                    System.out.print("Send: ");
                        String sendData = in.nextLine();
                        byte[] sendBuffer = sendData.getBytes();
                        InetAddress serverAdd = InetAddress.getByName("localhost");

                        DatagramPacket senDatagramPacket = new DatagramPacket(sendBuffer,sendBuffer.length,serverAdd,4545);
                        
                        socket.send(senDatagramPacket);
                    
                    
                        sleep(500);


                    //Data Recive ....................

                    byte[] reciveBuffer = new byte[1024];

                    DatagramPacket reciveDatagramPacket = new DatagramPacket(reciveBuffer, reciveBuffer.length);

                    socket.receive(reciveDatagramPacket);
                    String msg = new String(reciveDatagramPacket.getData(),0,reciveDatagramPacket.getLength());

                    System.out.println("Recived: "+msg);

                   

                    
                }
            }}
        catch (Exception e) {
            
        }


        

       

        







    }
}
