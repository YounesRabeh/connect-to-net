package web;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class SimpleHttpServer {
    public static HttpServer testServer;
    private static BasicAuthHandler basicAuthHandler = new BasicAuthHandler();
    public static void main(String[] args) {
        try {
            // Create HttpServer instance on port 8080
            testServer = HttpServer.create(new InetSocketAddress(8080), 0);

            // Set the context path and handler for the server with basic authentication
            testServer.createContext("/", basicAuthHandler);

            // Set the executor for handling incoming requests
            testServer.setExecutor(null); // Use default executor

            // Start the testServer
            testServer.start();
            System.out.println("testServer started on port 8080.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
