import java.io.*;
import java.net.*;
public class puertoDatagramSocket {
  //Crear un DatagramSocket puede resultar en una SocketException, podemos meterla
  //en un try-catch o lanzarla en el main (es una subExcepcion de IOexception)
  public static void main(String[] args) throws SocketException {
    //No especificamos el puerto en DatagramSocket(puerto) para que sea un cliente
    //Si lo hiciesemos sería un servidor con el puerto especificado en escucha
    DatagramSocket datagramSocket = new DatagramSocket();
    System.out.println("El puerto asignado es: " + datagramSocket.getLocalPort());
  }
}
