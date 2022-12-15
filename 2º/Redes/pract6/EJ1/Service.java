import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Service extends Thread{
  Socket client;
  public Service(Socket s)
  {
    client = s;
  }
  public void run()
  {
    try {
      Scanner entrada = new Scanner(client.getInputStream());
      PrintWriter salida = new PrintWriter(client.getOutputStream(),false);
      String respuesta = entrada.nextLine();
      while (!respuesta.equalsIgnoreCase("Fin"))
      {
        salida.printf(respuesta);
        salida.flush();
        respuesta = entrada.nextLine();
      }
      client.close();
    } catch (Exception e) {
      System.out.println(e);
    }  
  }
}
