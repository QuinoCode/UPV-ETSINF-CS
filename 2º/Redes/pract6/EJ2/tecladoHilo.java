import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class tecladoHilo extends Thread{
  Socket client;
  public tecladoHilo(Socket s)
  {
    client = s;
  }
  public void run()
  {
    try {
      Scanner entrada = new Scanner(System.in);
      PrintWriter salida = new PrintWriter(client.getOutputStream(),false);
      String respuesta = entrada.nextLine() + "\n";
      while (!respuesta.equalsIgnoreCase("quit"))
      {
        salida.printf(respuesta);
        salida.flush();
        respuesta = entrada.nextLine() + "\n";
      }
      client.close();
    } catch (Exception e) {
      System.out.println(e);
    }  
  }
}
