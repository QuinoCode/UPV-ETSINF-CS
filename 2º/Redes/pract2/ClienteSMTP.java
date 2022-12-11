package pract2;
import java.net.*;
import java.io.*;
import java.util.*;
public class ClienteSMTP {
    public static void main(String[] args) {
        System.setProperty("line.separator", "\r\n");
        try {
            InetAddress upv = InetAddress.getByName("smtp.upv.es");
            Socket peticion = new Socket((upv), 25);
            System.out.println("Conectado");
            Scanner lector = new Scanner(peticion.getInputStream());
            System.out.println(lector.nextLine());
            PrintWriter lapicero = new PrintWriter(peticion.getOutputStream(), true);
            lapicero.println("HELO rdc12.redes.upv.es"); //Checkear con el profe
            System.out.println(lector.nextLine());


            peticion.close();
        } catch (NoRouteToHostException e) {
            System.out.println("Servidor no localizado");
            System.out.println(e);
        } catch(IOException e) {
            System.out.println("Conexión fallida");
            System.out.println(e);
        }


    }
}
