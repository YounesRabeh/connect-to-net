package template.clients;


import rules.ClientType;
import rules.Subordinate;
import template.base.Client;

import java.net.Socket;

public class SuperClient extends Client implements Subordinate {
    public SuperClient(Socket clientSocket) {
        super(clientSocket, ClientType.SUPER);
    }

    @Override
    public ClientType getClientType() {
        return null;
    }
}
