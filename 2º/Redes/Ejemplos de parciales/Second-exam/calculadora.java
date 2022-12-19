import java.net.*;
import java.io.*;
import java.util.*;
public class calculadora
{
    // instance variables - replace the example below with your own
    public static void main(String[] args) throws IOException, UnknownHostException
    {
        int puerto = 8080;
        ServerSocket server = new ServerSocket(puerto);
        while(true)
        {
            Socket s = server.accept();
            Scanner entrada = new Scanner(s.getInputStream());
            String respuesta = entrada.nextLine();
            System.out.println(respuesta);
            if (respuesta.equalsIgnoreCase("SUMA"))
            {
                Suma cliente = new Suma(s);
                cliente.start();
            } else if (respuesta.equalsIgnoreCase("RESTA")) 
            {
                Resta cliente = new Resta(s);
                cliente.start();
            } else 
            {
                System.out.println("No es una operación valida, conectate de nuevo");
            }
            
        }
    }
}
