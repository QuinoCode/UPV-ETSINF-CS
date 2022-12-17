import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Suma extends Thread
{
    Socket client;
   public Suma(Socket s)
   {
        client = s;
    }
    public void run() 
    {
        try 
        {
            Scanner teclado = new Scanner(client.getInputStream());
            PrintWriter salida = new PrintWriter(client.getOutputStream(), false);
            int sumando1 = teclado.nextInt();
            int sumando2 = teclado.nextInt();
            int resultado = sumando1 + sumando2;
            
            salida.print(resultado);
            salida.flush();
        } catch (IOException e)
        {
            System.out.println(e);
        }
    }
    
}
