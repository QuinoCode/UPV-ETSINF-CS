import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteTCP3 {
    public static void main(String[] args) {


        try{
            InetAddress upv = InetAddress.getByName("www.upv.es.");
            int port = 80;
            Socket idk = new Socket((upv), 80);
            int remotePort = idk.getPort();
            int localPort = idk.getLocalPort();
            InetAddress remoteIP = idk.getInetAddress();
            InetAddress localIP = idk.getLocalAddress();

            System.out.println("Puerto local: " + localPort + "\n" + "Puerto remoto: " + remotePort);
            System.out.println("Dirección IP local: " + localIP + "\n" + "Dirección IP remota: " + remoteIP );
            idk.close();
        } catch (UnknownHostException e){
            System.out.println("Nombre de servidor deconocido");
            System.out.println(e);
        }
        catch (IOException e) {
            System.out.println("Fallo al cerrar el socket");
            System.out.println(e);
        }
    }
}
