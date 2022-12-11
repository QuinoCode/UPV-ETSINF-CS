import java.util.Scanner;
import java.io.*;
import java.net.*;
public class HTTPServidor {

  public static void main(String[] args) {

    try 
    {
    ServerSocket serverSocket = new ServerSocket(8080);
      while (true) 
      {
        Socket socket = serverSocket.accept();
        System.out.println("Un cliente se ha conectado con el servidor");
        Scanner entrada = new Scanner(socket.getInputStream());
        PrintWriter salida = new PrintWriter(socket.getOutputStream(), false);
        String respuesta = entrada.nextLine();
        //Esta condición funciona pero siempre he usado !respuesta.startsWith(".");Preguntar al profesor
        while (!respuesta.equals("")) 
        {
          salida.printf(respuesta);
          System.out.println(respuesta);
          respuesta = entrada.nextLine();
          salida.flush();
        }
        socket.close();
      } 
    } catch (IOException e) 
      {
        System.out.println(e);
      }
    
  }
}
