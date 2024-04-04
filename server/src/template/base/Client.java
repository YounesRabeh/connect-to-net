package template.base;

import template.ClientRecord;

import java.net.Socket;

public abstract class Client extends Host {
    // Upon Connected
    // ----

    // Dynamic

    // Custom
    private String username; //TODO: pretty useless

    public Client(Socket clientSocket) {
        super(clientSocket);

        //TODO: see if the return type is indeed the super class not just 'Client'
        new ClientRecord(this, 1); // Assuming ClientRecord handles client record creation
    }

    public String getUsername() { return username; }

}
