//Service es la clase concurrente que implementa el método 'Run' encargado 
// de hacer el espejo. 
//Esta clase se encarga de crear un hilo para que atienda a cada cliente que necesite el servicio para que 
// se pueda atender a varios clientes a la vez
import java.net.*;
import java.io.*;

public class EcoTCP {
  public static void main(String[] args) throws IOException, UnknownHostException {
    
  
  int puerto = 7777;
  ServerSocket server = new ServerSocket(puerto);
  while (true)
  {
    Service cliente = new Service(server.accept());
    cliente.start();
  }
  }
}
