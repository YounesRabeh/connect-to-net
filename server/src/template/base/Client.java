package template.base;

import template.ClientRecord;

import java.net.Socket;

import static db.DataBaseManager.getAnID;

public abstract class Client extends Host {
    // Upon Connected
    public final Integer ID;

    // Dynamic
    private String username; //TODO: pretty useless


    public Client(Socket clientSocket) {
        super(clientSocket); this.ID = getAnID();

        //TODO: see if the return type is indeed the super class not just 'Client'
        new ClientRecord(this, ID); // Assuming ClientRecord handles client record creation
    }

    public String getUsername() { return username; }

}
