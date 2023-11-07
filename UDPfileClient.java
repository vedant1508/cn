import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPfileClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName("localhost"); // Change to the server's IP address

            FileInputStream fileInputStream = new FileInputStream("udpfiletosend.txt");
            byte[] sendData = new byte[1024];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(sendData)) != -1) {
                DatagramPacket sendPacket = new DatagramPacket(sendData, bytesRead, serverAddress, 9876);
                socket.send(sendPacket); // Send the data
            }

            fileInputStream.close();
            socket.close();

            System.out.println("File sent successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
