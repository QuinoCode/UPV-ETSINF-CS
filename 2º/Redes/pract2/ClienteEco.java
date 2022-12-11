package pract2;

import java.net.*;
import java.io.*;
import java.util.*;
public class ClienteEco {
    public static void main(String[] args) {
        try {
            InetAddress upv = InetAddress.getByName("zoltar.redes.upv.es");
            Socket escritor = new Socket((upv), 7);
            System.out.println("Conectado");
            Scanner lector = new Scanner(escritor.getInputStream());
            PrintWriter lapicero = new PrintWriter(escritor.getOutputStream(), false);

            lapicero.println("¡Hello World!");
            lapicero.flush();
            while(lector.hasNext()){ System.out.println(lector.nextLine());}
            lector.close();


        } catch (UnknownHostException e) {
            System.out.println("Nombre del servidor desconocido");
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Fallo al conectarse al servidor");
            System.out.println(e);
        }
    }

}
