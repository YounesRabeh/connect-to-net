package template.base;

import rules.ClientType;

import java.net.Socket;


public abstract class Client extends Host {
    // Upon Connected
    private final Integer ID;

    // Dynamic
    private String username; //TODO: pretty useless

    public Client(Socket clientSocket) {
        super(clientSocket);
        this.ID = 0;
    }

    public String getUsername() {
        return username;
    }

    public Integer getID() {
        return ID;
    }

}
