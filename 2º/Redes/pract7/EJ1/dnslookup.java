import java.io.*;
import java.net.*;
public class dnslookup{
  public static void main(String[] args) throws IOException, UnknownHostException{
    // Este if es innecesario pero cubre la excepción que surgiría si se nos olvida poner un argumento al ejecutar
    if (args.length == 0)
    {
      System.out.println("Al ejecutar este programa has de añadir al menos un argumento");
      System.exit(1);
    }
    try
    {
      InetAddress host = InetAddress.getByName(args[0]);
      System.out.println(host.toString());

    } catch (UnknownHostException e) 
    {
      System.out.println("No se ha podido encontrar host");
      System.out.println(e);
    }  
  }
}
