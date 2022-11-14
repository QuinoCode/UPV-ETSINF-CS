import java.net.*;
import java.io.*;
import java.util.*;
public class ClienteHTTP {
    public static void main(String[] args) {
        System.setProperty("line.separator", "\r\n");
        try {
            InetAddress IPUpv = InetAddress.getByName("www.upv.es");
            Socket http = new Socket((IPUpv), 80);
            PrintWriter peticion = new PrintWriter(http.getOutputStream(), true);
            peticion.println("GET / HTTP/1.0\r\n\r\n");
            Scanner lector = new Scanner(http.getInputStream());
            while(lector.hasNext())  System.out.println(lector.nextLine());
            http.close();

        } catch (UnknownHostException e) {
            System.out.println("Servidor no encontrado");
            System.out.println(e);
        }  catch (IOException e) {
            System.out.println("Conexión fallida");
            System.out.println(e);
        }
    }

}
