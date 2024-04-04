package startup;

import template.base.Client;
import template.clients.BasicClient;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Start {
    private static final int PORT = 3214;
    private static final long HEARTBEAT_INTERVAL = 2000; // 2 seconds
    private static Map<Integer, BasicClient> clientMap = new HashMap<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server Started [" + PORT + "]");

            // Listen for connections and handle each client in a separate thread
            while (true) {
                BasicClient client = new BasicClient(serverSocket.accept());
                clientMap.put(client.getID(), client);

                Thread clientThread = new Thread(() -> {
                    System.out.print("New client connected: " + client.getName() + "\nID : "+ client.getID());
                    System.out.println("\t> Connected at " + client.getFormattedConnectionTime());

                    try {
                        while (true) {
                            Thread.sleep(HEARTBEAT_INTERVAL); // Wait for heartbeat interval
                            //FixME: socket close not detected
                            clientConnected();
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
    private static void clientConnected() {
        Iterator<Map.Entry<Integer, BasicClient>> iterator = clientMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, BasicClient> entry = iterator.next();
            Client client = entry.getValue();
            if (!client.isConnected()) {
                System.out.println("Client disconnected: " + client.getID());
                iterator.remove();
            }
        }
    }


}
