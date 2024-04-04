package template.clients;

import template.access.ClientType;
import template.access.Subordinate;
import template.base.Client;
import java.net.Socket;

public class AdminClient extends Client implements Subordinate {
    public AdminClient(Socket clientSocket) {
        super(clientSocket);
    }

    @Override
    public ClientType getClientType() {
        return null;
    }
}
