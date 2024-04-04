package template.clients;


import template.Client;
import java.net.Socket;

import static template.ClientType.SUPER;

public class SuperClient extends Client {
    public SuperClient(Socket clientSocket) {
        super(clientSocket, SUPER);
    }
}
