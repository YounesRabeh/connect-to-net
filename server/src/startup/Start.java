package startup;

import db.DBMS;
import template.base.Client;
import template.clients.AdminClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Arrays;


public class Start {
    private static final int PORT = 8080;
    private static final long HEARTBEAT_INTERVAL = 200; // 2 seconds

    Start(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server Started [" + PORT + "]");
            System.out.println("server sovket address: " + Arrays.toString(serverSocket.getInetAddress().getAddress()));

            DBMS.init();
            // Listen for connections and handle each client in a separate thread
            while (true) {
                AdminClient client = new AdminClient(serverSocket.accept());

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

    }


}
