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

        // Assuming ClientRecord handles client record creation
    }

}
