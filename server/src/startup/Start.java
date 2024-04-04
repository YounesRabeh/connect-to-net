package startup;

import template.clients.BasicClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Start {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3214);
            System.out.println("Server Started [3214]");
            BasicClient client1 = new BasicClient(serverSocket.accept());
            System.out.println("client1 name = " + client1.getName());
            System.out.println("connected since " + client1.getFormattedConnectionTime());
            Thread.sleep(1000);
            System.out.println("connected for " + client1.getFormattedConnectionDuration());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
