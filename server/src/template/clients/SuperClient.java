package template.clients;


import template.access.ClientType;
import template.access.Subordinate;
import template.base.Client;
import java.net.Socket;

public class SuperClient extends Client implements Subordinate {
    public SuperClient(Socket clientSocket) {
        super(clientSocket);
    }

    @Override
    public ClientType getClientType() {
        return null;
    }
}
