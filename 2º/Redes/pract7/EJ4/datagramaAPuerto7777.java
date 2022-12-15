import java.net.*;
import java.io.*;
import java.util.*;
public class datagramaAPuerto7777 {
  public static void main(String[] args) throws IOException, SocketException {
    DatagramSocket cliente = new DatagramSocket();
    //Hay que enviar un datagramPacket
    String mensaje = "Paquete enviado";
    byte[] mensajeEnBytes = mensaje.getBytes();
    int longitudEnBytes = mensajeEnBytes.length;
    InetAddress ipDestino = InetAddress.getByName("localhost");
    int puertoDestino = 7777;
    DatagramPacket enviado = new DatagramPacket(mensajeEnBytes, longitudEnBytes, ipDestino, puertoDestino);
    cliente.send(enviado);
    //Hipótesis de continuación
    // DatagramSocket servidor = new DatagramSocket(7777);
    //Buffer recepción 
    byte[] buffer = new byte[512];
    DatagramPacket recibido = new DatagramPacket(buffer, 512);
    cliente.receive(recibido);
    //Ahora construimos el mensaje para poder printearlo
    //new String (getData traduce los bits que tiene que hacer, 0
    //-esto es el offset, normalmente no queremos-, getLength manda la longitud del mensaje concreta, hace falta)
    String mensajeAPrintear = new String(recibido.getData(), 0, recibido.getLength());
    System.out.println(mensajeAPrintear);
    cliente.close();
  }
}
