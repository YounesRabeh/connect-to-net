package template.clients;

import rules.ClientType;
import rules.Subordinate;
import template.base.Client;
import java.net.Socket;

import static rules.ClientType.BASIC;

public class BasicClient extends Client implements Subordinate {
    // TODO: add upgrading/downgrading the clients
    private final ClientType clientType;

    public BasicClient(Socket clientSocket) {
        super(clientSocket);
        this.clientType = BASIC;
    }

    @Override
    public ClientType getClientType() { return clientType; }
}
