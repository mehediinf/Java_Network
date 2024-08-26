import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDP_Server {
    public static void main(String[] args) throws IOException{
      
        
        try {
            try (DatagramSocket datagramSocket = new DatagramSocket(4545)) {
                byte[] reciveBuffer =new byte[1024];
                System.out.println("Server is running... ");


                while (true) {

                    DatagramPacket recivePacket = new DatagramPacket(reciveBuffer, reciveBuffer.length);
                    datagramSocket.receive(recivePacket);

                    String message = new String(recivePacket.getData(),0,recivePacket.getLength());
                    System.out.println("Recived: "+message);



                    String respons = "Hello,Client";
                    byte[] sensBuffer = respons.getBytes();

                    DatagramPacket senDatagramPacket = new DatagramPacket(sensBuffer, sensBuffer.length,recivePacket.getAddress(),recivePacket.getPort());
                    datagramSocket.send(senDatagramPacket);
                    
                }
            }




        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    
    }
}


