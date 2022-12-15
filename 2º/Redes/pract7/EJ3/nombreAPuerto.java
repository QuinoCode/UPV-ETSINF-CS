import java.net.*;
import java.io.*;
import java.util.*;
public class nombreAPuerto {
  public static void main(String[] args) throws SocketException, IOException {
    DatagramSocket cliente = new DatagramSocket();
    //DatagramPacket mensaje = new DatagramPacket(argumentos);
    // Argumentos = (mensaje(en bytes), longitudMensaje, IP destino, puerto destino)
    //Argumentos para el datagram DatagramPacket:
    //Mensaje que queremos enviar en String
    String mensaje = "Nombre generico promedio español \n";
    //Mensaje en bytes
    byte mensajeEnBytes[] = mensaje.getBytes();
    //Longitud del mensaje:
    int longitudMensaje = mensajeEnBytes.length;
    //Dirección IP destino:
    InetAddress ipDestino = InetAddress.getByName("localhost");
    //Puerto destino
    int port = 7777;

    DatagramPacket dGramPacket = new DatagramPacket(mensajeEnBytes, longitudMensaje, ipDestino, port);
    cliente.send(dGramPacket);
    cliente.close();
  }
}
