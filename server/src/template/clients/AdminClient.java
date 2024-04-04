package template.clients;

import template.Client;
import java.net.Socket;

import static template.ClientType.ADMIN;


public class AdminClient extends Client {
    public AdminClient(Socket clientSocket) {
        super(clientSocket, ADMIN);
    }
}
