package template.clients;

import db.DBMS;
import db.records.ClientRecord;
import rules.Subordinate;
import template.base.Client;

import java.net.Socket;

import static rules.ClientType.ADMIN;

public class AdminClient extends Client implements Subordinate {
    public AdminClient(Socket clientSocket) {
        super(clientSocket, ADMIN);
    }

}
