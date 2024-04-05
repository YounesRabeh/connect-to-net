package template.base;

import db.tables.records.ClientRecord;

import java.net.Socket;

import static db.DataBase.assignID;

public abstract class Client extends Host {
    // Upon Connected
    public final Integer ID;

    // Dynamic
    private String username; //TODO: pretty useless

    public Client(Socket clientSocket) {
        super(clientSocket); this.ID = assignID();

        //TODO: see if the return type is indeed the super class not just 'Client'
        new ClientRecord(this, ID); // Assuming ClientRecord handles client record creation
    }

    public String getUsername() { return username; }
    public Integer getID() { return ID; }

}
