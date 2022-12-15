import java.net.*;
import java.io.*;
import java.util.Scanner;

public class chat {
  public static void main(String[] args) throws IOException, UnknownHostException {
    
  
  int puerto = 7777;
  ServerSocket server = new ServerSocket(puerto);
  while (true)
  {
    Socket socket =server.accept();
    tecladoHilo cliente = new tecladoHilo(socket);
    cliente.start();
    Scanner entrada = new Scanner(socket.getInputStream());
    String respuesta = entrada.nextLine();
    while (entrada.hasNext())
    {
        System.out.println(respuesta + "\n");
        respuesta = entrada.nextLine();
    }
  }
  }
}
