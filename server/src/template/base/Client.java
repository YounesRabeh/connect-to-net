package template.base;


import rules.ClientType;

import java.net.Socket;



public abstract class Client extends Host {
    // Upon Connected
    private final Integer ID;
    // TODO: add upgrading/downgrading the clients
    private ClientType clientType;

    // Dynamic
    private String username; //TODO: pretty useless

    public Client(Socket clientSocket, ClientType clientType) {
        super(clientSocket);
        this.ID = 0;
        this.clientType = clientType;

    }

    public String getUsername() {
        return username;
    }

    public Integer getID() {
        return ID;
    }
    public ClientType getClientType() {
        return clientType;
    }

}
