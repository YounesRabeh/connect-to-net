package template.clients;


import template.access.ClientType;
import template.access.Subordinate;
import template.base.Client;
import java.net.Socket;

import static template.access.ClientType.SUPER;

public class SuperClient extends Client implements Subordinate {
    public SuperClient(Socket clientSocket) {
        super(clientSocket);
    }

    @Override
    public ClientType getClientType() {
        return null;
    }
}
