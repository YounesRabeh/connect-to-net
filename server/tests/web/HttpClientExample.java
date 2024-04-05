package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class HttpClientExample {
    public static void main(String[] args) {
        try {
            // URL of your server
            URL url = new URL("http://localhost:8080/");

            // Open a connection to the server
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method (GET, POST, etc.)
            connection.setRequestMethod("GET");

            // Set Basic Authentication header
            String username = "admin";
            String password = "password";
            String authString = username + ":" + password;
            String encodedAuthString = Base64.getEncoder().encodeToString(authString.getBytes());
            connection.setRequestProperty("Authorization", "Basic " + encodedAuthString);

            // Send the request and get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Get server details
            URL serverUrl = connection.getURL();
            String protocol = serverUrl.getProtocol();
            String hostName = serverUrl.getHost();
            int portNumber = serverUrl.getPort(); // If not explicitly specified, default port for HTTP is 80

            System.out.println("> Server Details:");
            System.out.println(" ├ Protocol: " + protocol);
            System.out.println(" ├ Host Name: " + hostName);
            System.out.println(" └ Port Number: " + portNumber);

            // Get client details
            String clientProtocol = "http"; // For simplicity, assuming HTTP
            String clientHostName = "localhost"; // Your client's hostname or IP address
            int clientPortNumber = 12345; // Your client's port number (modify as needed)

            System.out.println("> My (Client) Details:");
            System.out.println(" ├ Protocol: " + clientProtocol);
            System.out.println(" ├ Host Name: " + clientHostName);
            System.out.println(" └ Port Number: " + clientPortNumber);

            // Read the response from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            // Print the response from the server
            System.out.print("Response from server: ");
            System.out.println(response.toString());

            // Hold the connection for 10 seconds (10000 milliseconds)
            Thread.sleep(100000);

            // Disconnect the connection
            connection.disconnect();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

