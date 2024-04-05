package web;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleHttpServer {
    public static HttpServer testServer;
    private static BasicAuthHandler basicAuthHandler = new BasicAuthHandler();

    public static void main(String[] args) {
        int port = 3306;
        try {
            // Create HttpServer instance on port 8080
            testServer = HttpServer.create(new InetSocketAddress(port), 0);

            // Set the context path and handler for the server with basic authentication
            testServer.createContext("/", basicAuthHandler);

            // Set the executor for handling incoming requests
            testServer.setExecutor(null); // Use default executor

            // Start the testServer
            testServer.start();
            System.out.println("testServer started on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
