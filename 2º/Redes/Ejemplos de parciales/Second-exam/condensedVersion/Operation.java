import java.net.*;
import java.util.*;
import java.io.*;

public class Operation extends Thread{

  Socket client;

  public Operation(Socket s)
  {
    client = s;
  }

  public void run()
  {
    try
    {
      Scanner entrada = new Scanner(client.getInputStream());
      PrintWriter salida = new PrintWriter(client.getOutputStream(), false);
      String respuesta = entrada.nextLine();
      System.out.println("Una " + respuesta + " ha sido solicitada");
      if (respuesta.equalsIgnoreCase("SUMA"))
      {
        int sumando1 = entrada.nextInt();
        int sumando2 = entrada.nextInt();
        int resultado = sumando1 + sumando2;
        respuesta = "El resultado de la operación " + sumando1 + " + " + sumando2 + " = " + resultado;
        salida.printf(respuesta);
        salida.flush();
        client.close();
      } else if (respuesta.equalsIgnoreCase("RESTA"))
        {
          int numero1 = entrada.nextInt();
          int numero2 = entrada.nextInt();
          int resultado = numero1 - numero2;
          respuesta = "El resultado de la operación " + numero1 + " - " + numero2 + " = " + resultado;
          salida.printf(respuesta);
          salida.flush();
          client.close();
        } else { System.out.println("La operación introducida no es valida, vuelva a conectarse"); }
    } catch (IOException e) { System.out.println(e); }
    //Esto de aquí abajo no lo pide, pero por dejarlo niquelado.
    catch (InputMismatchException e)
    {
      String mensaje = "Sólo se pueden hacer operaciones con números, vuelva a conectarse.";
      try {
        PrintWriter salida = new PrintWriter(client.getOutputStream(), false);
        salida.printf(mensaje);
        salida.flush();
      } catch (IOException ex) {
        System.out.println(ex);
      }
    }
  }
}

