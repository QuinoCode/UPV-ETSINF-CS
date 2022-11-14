package pract2;
import java.net.*;
import java.io.*;
import java.util.*;
public class ClienteDayTime {
    public static void main(String[] args) {
        try {
            InetAddress upv = InetAddress.getByName("zoltar.redes.upv.es.");
            Socket fecha = new Socket((upv), 13);
            System.out.println("Conectado");
            Scanner leeFecha = new Scanner(fecha.getInputStream());
            System.out.println(leeFecha.nextLine());
        } catch (UnknownHostException e) {
            System.out.println("Nombre de servidor desconocido");
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("No es posible realizar la conexión");
            System.out.println(e);
        }

    }
}
