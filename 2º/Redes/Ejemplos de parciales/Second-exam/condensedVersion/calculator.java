import java.net.*;
import java.io.*;
import java.util.Scanner;

public class calculator {
  public static void main(String[] args) {
    try {
      int port = 8080;
      ServerSocket server = new ServerSocket(port);
      while (true) {
        Socket s = server.accept();
        Scanner entrada = new Scanner(s.getInputStream());
        Operation client = new Operation(s);
        client.start();
        System.out.println(entrada.nextLine());
      }
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
