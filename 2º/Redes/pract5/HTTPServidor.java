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
        // Las tres líneas que pide en el enunciado (creo que es para que sepa como "displayear" el contenido)       
        salida.printf("HTTP/1.0 200 OK\r\n");
        salida.printf("Content-Type: text/plain\r\n");
        salida.printf("\r\n");
        
        String respuesta = entrada.nextLine();
        // Creo también que solo hay que enviar las cabeceras, es decir, la petición, solo las cabeceras están hasta la primera ocurrecia de una línea en blanco
        while (!respuesta.equals("")) 
        {
          salida.println(respuesta);
          salida.flush();
          respuesta = entrada.nextLine();
        }
        socket.close();
      } 
    } catch (IOException e) 
      {
        System.out.println(e);
      }
    
  }
}
