//EL objetivo de este exámen es mandarle un numero al ordenador del profesor de prácticas y este os devuelve
//si habéis acercado el número y si no te dirán si es mayor o menor y tienes que ser capaz de recibir ese examen
import java.net.*;
import java.util.*;

import java.io.*;
public class examen
{
	public static void main(String[] args)
	{
		try 
		{
			InetAddress upv = InetAddress.getByName("zoltar.redes.upv.es.");
			Socket s = new Socket((upv), 80);//El 80 lo cambias por el puerto que te den
			Scanner entrada = new Scanner(s.getInputStream());
			Scanner teclado = new Scanner(System.in);
			//PrintWriter salida = new PrintWriter(s.getOuptputStream(), false);
			PrintWriter salida = new PrintWriter(s.getOutputStream(), false);
			salida.println(teclado.nextInt());
			salida.flush();
			String respuesta = entrada.nextLine();
			System.out.println(respuesta);
			while (!respuesta.startsWith(".")) 
			{
				salida.println(teclado.nextInt());
				salida.flush();
				System.out.println(respuesta);
				respuesta = entrada.nextLine();
				
			}
			System.out.println("Acertado");
			s.close();
			System.out.println("Desconectado");
			
			

		}
		catch (NoRouteToHostException e) 
		{
			System.out.println("Host desconocido");
			System.out.println(e);
		}
		catch (IOException e)
		{
			System.out.println("No se pudo conectar");
			System.out.println(e);
		}

	}
}
