package web;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

public class BasicAuthHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Extract Authorization header from request
        String authHeader = exchange.getRequestHeaders().getFirst("Authorization");

        // Check if Authorization header is present and contains credentials
        if (authHeader != null && authHeader.startsWith("Basic ")) {
            // Extract Base64-encoded credentials from the header
            String encodedCredentials = authHeader.substring("Basic ".length()).trim();
            // Decode Base64-encoded credentials
            String decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials));

            // Check if decoded credentials are valid (replace this with your authentication logic)
            if (isValidCredentials(decodedCredentials)) {
                // Authentication successful, send response
                String response = "Authenticated successfully!";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();

                // Print client information
                printClientInfo(exchange);
                return;
            }
        }

        // Authentication failed or credentials not provided, send 401 Unauthorized response
        String response = "Unauthorized access!";
        exchange.getResponseHeaders().set("WWW-Authenticate", "Basic realm=\"Server\"");
        exchange.sendResponseHeaders(401, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private boolean isValidCredentials(String decodedCredentials) {
        // Implement your own logic to validate credentials here
        // For example, compare with a database or predefined values
        return decodedCredentials.equals("admin:password"); // Example credentials for testing
    }

    private void printClientInfo(HttpExchange exchange) {
        // Get client's remote address
        String clientAddress = exchange.getRemoteAddress().getAddress().toString();
        int clientPort = exchange.getRemoteAddress().getPort();

        System.out.println("New client connected:");
        System.out.println("Client Address: " + clientAddress);
        System.out.println("Client Port: " + clientPort);
    }
}
