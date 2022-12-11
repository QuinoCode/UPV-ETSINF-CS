import java.util.Scanner;
import java.io.*;
import java.net.*;
public class InfoEcoServidor {

  public static void main(String[] args) {

    try {
    ServerSocket serverSocket = new ServerSocket(7777);
      //Now will show in screen the IP and the Port that is used by the server
    System.out.println(serverSocket.getInetAddress());
    System.out.println(serverSocket.getLocalPort());
      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("Un cliente se ha conectado con el servidor:");
        System.out.println(socket.getPort());
        System.out.println(socket.getInetAddress());
        Scanner entrada = new Scanner(socket.getInputStream());
        PrintWriter salida = new PrintWriter(socket.getOutputStream(), false);
        String respuesta = entrada.nextLine();
        salida.printf(respuesta);
        salida.flush();
        socket.close();
      } 
    } catch (IOException e) {
      System.out.println(e);
    }
    
  }
}
