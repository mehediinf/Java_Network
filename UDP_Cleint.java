import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_Cleint {
    public static void main(String[] args) {
       
        try {
            DatagramSocket datagramSocket = new DatagramSocket(4545);
            
                InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
                String message = "Hello,Server";
                byte[] sendBuffer = message.getBytes();


                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length,serverAddress,4545);
                datagramSocket.send(sendPacket);

                byte[] reciveBuffer = message.getBytes();
                DatagramPacket reciveDatagramPacket = new DatagramPacket(reciveBuffer, reciveBuffer.length);
                datagramSocket.receive(reciveDatagramPacket);

                String respons = new String(reciveDatagramPacket.getData(),0,reciveDatagramPacket.getLength());
                System.out.println("Server Respons: "+respons);

                datagramSocket.close();

            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
