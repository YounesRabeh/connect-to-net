package web;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleHttpServer {
    public static void main(String[] args) {
        try {
            // Create HttpServer instance on port 8080
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

            // Set the context path and handler for the server with basic authentication
            server.createContext("/", new BasicAuthHandler());

            // Set the executor for handling incoming requests
            server.setExecutor(null); // Use default executor

            // Start the server
            server.start();
            System.out.println("Server started on port 8080.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
