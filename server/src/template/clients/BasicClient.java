package template.clients;

import db.types.records.ClientRecord;
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

        //TODO: see if the return type is indeed the super class not just 'Client'
        new ClientRecord(ID, this);
        // Assuming ClientRecord handles client record creation
    }

    @Override
    public ClientType getClientType() {
        return clientType;
    }
}
