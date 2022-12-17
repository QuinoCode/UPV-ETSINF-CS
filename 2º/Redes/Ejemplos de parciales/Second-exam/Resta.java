

import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Resta extends Thread
{
    Socket client;
   public Resta(Socket s)
   {
        client = s;
    }
    public void run() 
    {
        try 
        {
            Scanner teclado = new Scanner(client.getInputStream());
            PrintWriter salida = new PrintWriter(client.getOutputStream(), false);
            int numero1 = teclado.nextInt();
            int numero2 = teclado.nextInt();
            int resultado = numero1 - numero2;
            salida.print(resultado);
            salida.flush();
        } catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
