import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteTCP2 {
    public static void main(String[] args) {


        try{
            InetAddress upv = InetAddress.getByName("www.upv.es.");
            int port = 80;
            Socket idk = new Socket((upv), 81);
            System.out.println("Conectado");
            idk.close();
        } catch (UnknownHostException e) {
            System.out.println("Nombre de servidor deconocido");
            System.out.println(e);
        }
        catch (IOException e) {
            System.out.println("Fallo al cerrar el socket");
            System.out.println(e);
        }
    }
}
