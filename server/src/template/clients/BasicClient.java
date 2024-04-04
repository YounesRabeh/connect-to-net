package template.clients;

import template.Client;

import java.net.Socket;

import static template.ClientType.BASIC;

public class BasicClient extends Client {


    public BasicClient(Socket clientSocket) {
        super(clientSocket, BASIC);
    }
}
