package template.clients;

import db.DBMS;
import db.records.ClientRecord;
import rules.ClientType;
import rules.Subordinate;
import template.base.Client;

import java.net.Socket;

import static rules.ClientType.BASIC;

public class BasicClient extends Client implements Subordinate {


    public BasicClient(Socket clientSocket) {
        super(clientSocket, BASIC);


        //TODO: see if the return type is indeed the super class not just 'Client'
        DBMS.add(new ClientRecord(this));
        // Assuming ClientRecord handles client record creation
    }

}
