package startup;

import db.DBMS;
import template.base.Client;
import template.clients.AdminClient;
import template.clients.BasicClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Start {
    private static final int PORT = 3215;
    private static final long HEARTBEAT_INTERVAL = 2000; // 2 seconds
    private static Map<Integer, Client> clientMap = new HashMap<>();
    private static int NUM = 0;

    Start(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server Started [" + PORT + "]");

            DBMS.init();
            // Listen for connections and handle each client in a separate thread
            while (true) {
                AdminClient client = new AdminClient(serverSocket.accept());
                clientMap.put(NUM++, client);

                Thread clientThread = new Thread(() -> {
                    System.out.print("New client connected: " + client.getName() + "\nID : " + client.getID());
                    System.out.println("\t> Connected at " + client.getFormattedConnectionTime());

                    try {
                        while (true) {
                            Thread.sleep(HEARTBEAT_INTERVAL); // Wait for heartbeat interval
                            //FixME: socket close not detected
                            checkConnectedClients();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                clientThread.start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to remove client from the clientMap
    private static void checkConnectedClients() {
        Iterator<Map.Entry<Integer, Client>> iterator = clientMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Client> entry = iterator.next();
            Client client = entry.getValue();
            if (!client.isHostUp()) {
                System.out.println("Client " + client.getID() + " disconnected");
                //releaseClientID(client.getID());
                iterator.remove();
                System.out.println("Current up-hosts: " + clientMap.size());
            }
        }
    }


}
