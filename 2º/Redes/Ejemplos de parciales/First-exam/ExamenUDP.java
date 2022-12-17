//Este examen no lo hice yo pero me lo pasaron, ahí lo llevais
import java.net.*;
import java.io.*; 
import java.util.*;

public class ExamenUDP {

	public static void main(String[] args) 
	{
		DatagramSocket s = new DatagramSocket(8006);
		Datagram Packet p = nnew DatagramPacket( new byte[512], 512);
		ServerSocket ss = new ServerSocket();
		int m = ss.getLocalPort();
		String msg = Integer.toString(m);
		byte[] buf = new byte[256];
		buf = msg.getBytes();
		s.send(p);
		s.receive(p);// se bloquea hasta que recibe un datagrama
		String ans = new String(p.getData(), 0, p.getLength());
		System.out.println(ans);
		s.close();
		ss.close();
	}
}
