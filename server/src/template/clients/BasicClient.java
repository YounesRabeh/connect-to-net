package template.clients;

import template.Client;

import java.net.Socket;

public class BasicClient extends Client {


    public BasicClient(Socket clientSocket) {
        super(clientSocket);
    }
}
