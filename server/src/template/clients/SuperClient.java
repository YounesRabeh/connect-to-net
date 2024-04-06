package template.clients;


import rules.Subordinate;
import template.base.Client;

import java.net.Socket;

import static rules.ClientType.SUPER;

public class SuperClient extends Client implements Subordinate {
    public SuperClient(Socket clientSocket) {
        super(clientSocket, SUPER);
    }

}
