package template;

import java.net.Socket;

public abstract class Client extends Host {
    // Upon Connected
    // TODO: add upgrading/downgrading the clients
    private ClientType clientType;

    // Custom
    private String username; //TODO: pretty useless

    public Client(Socket clientSocket, ClientType clientType) {
        super(clientSocket);
        this.clientType = clientType;

        new ClientRecord(this, 1); // Assuming ClientRecord handles client record creation
    }

    public ClientType getClientType() { return clientType; }

    public String getUsername() { return username; }

}
