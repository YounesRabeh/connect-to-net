package template.clients;

import template.access.ClientType;
import template.access.Subordinate;
import template.base.Client;
import java.net.Socket;

import static template.access.ClientType.BASIC;

public class BasicClient extends Client implements Subordinate {
    // TODO: add upgrading/downgrading the clients
    private ClientType clientType;

    public BasicClient(Socket clientSocket) {
        super(clientSocket);
        this.clientType = BASIC;
    }

    @Override
    public ClientType getClientType() { return clientType; }
}
