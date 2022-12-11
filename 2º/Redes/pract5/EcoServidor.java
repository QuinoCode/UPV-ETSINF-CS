import java.util.Scanner;
import java.io.*;
import java.net.*;
public class EcoServidor {

  public static void main(String[] args) {

    try {
    ServerSocket serverSocket = new ServerSocket(7777);
      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("Un cliente se ha conectado con el servidor");
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
