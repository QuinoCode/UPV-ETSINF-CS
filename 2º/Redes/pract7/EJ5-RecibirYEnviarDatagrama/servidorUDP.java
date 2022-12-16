import java.net.*;
import java.util.Date;
import java.io.*;
public class servidorUDP {
  public static void main(String[] args) throws SocketException, IOException {
    DatagramSocket server = new DatagramSocket(7777);
    byte buffer[] = new byte[512];
    int tamañoPaquete = 512;
    DatagramPacket dPacket = new DatagramPacket(buffer, tamañoPaquete);
    //Para que solo espere 5 segundos para recibir un paquete
    try
    {
    server.setSoTimeout(5000);
    server.receive(dPacket);
    Date fecha = new Date();
    String fecha_String = fecha.toString() + "\r\n";
    byte mensaje[] = fecha_String.getBytes();
    int longitudMensaje = mensaje.length;
    dPacket.setData(mensaje);
    dPacket.setLength(longitudMensaje);
    server.send(dPacket);
    server.close();
    //Si no se reusase el mismo socket habría que tomar la dirección destino y el puerto destino
    // InetAddress ipDestino = dPacket.getAddress();
    // int puertoDestino = dPacket.getPort();
    } catch (SocketTimeoutException e)
  {
      System.out.println("Has tardado demasiado en mandar un mensaje, solo tienes 5 segundos.");
    }
  }
}
