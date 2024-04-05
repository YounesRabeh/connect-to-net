package template.clients;

import rules.ClientType;
import rules.Subordinate;
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
