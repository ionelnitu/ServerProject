import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        while (true) {
            try (DatagramSocket datagramSocket = new DatagramSocket()) {
                byte[] buffer = new byte[256];
                Scanner in = new Scanner(System.in);
                System.out.println("Introduceti primul numar pentru adunare in intervalul nu mai mare de 127 ");
                byte a = in.nextByte();
                System.out.println("Introduceti al doilea numar pentru adunare nu mai mare de 127 ");
                byte b = in.nextByte();
                buffer[0] = a;
                buffer[1] = b;
                InetSocketAddress ep = new InetSocketAddress("localhost", 1080);
                DatagramPacket p = new DatagramPacket(buffer, buffer.length, ep);
                datagramSocket.send(p);
                System.out.println("Mesaj trimis!");
                datagramSocket.receive(p);
                System.out.print("Rezultatul este: ");
                System.out.print(buffer[0] + "\n");
            } catch (IOException esc) {
                System.out.println(esc.getMessage());
            }
        }
    }
}

