import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) {

        while (true) {
            try (DatagramSocket datagramSocket = new DatagramSocket(1080)) {
                System.out.println("Listening...");
                byte[] buffer = new byte[256];
                DatagramPacket p = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(p);
                System.out.println("Mesaj primit!");
                int  a = buffer[0];
                int b = buffer[1];
                byte c= (byte) (a+b);
                buffer[0]=c;
                datagramSocket.send(p);
                System.out.println("mesaj trimis");
            } catch (IOException esc) {
                System.out.println(esc.getMessage());
            }

        }
    }
}
