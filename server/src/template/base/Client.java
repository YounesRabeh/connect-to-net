package template.base;


import db.DBMS;
import db.records.ClientRecord;
import rules.ClientType;

import java.net.Socket;



public abstract class Client extends Host {

    // Dynamic
    private String username; //TODO: pretty useless
    // TODO: add upgrading/downgrading the clients
    private ClientType clientType;

    // Upon Connected
    private final Integer ID;



    public Client(Socket clientSocket, ClientType clientType) {
        super(clientSocket);
        this.clientType = clientType;
        this.ID = this.hashCode();
        DBMS.add(new ClientRecord(this))
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
