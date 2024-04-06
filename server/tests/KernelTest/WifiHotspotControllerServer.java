package KernelTest;
import db.DBMS;
import template.clients.BasicClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class WifiHotspotControllerServer {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        try {
            if (osName.contains("windows")) {
                // Execute netsh command to turn on WiFi hotspot on Windows
                Process process = new ProcessBuilder("netsh", "wlan", "set", "hostednetwork", "mode=allow", "ssid=MyHotspot", "key=MyPassword").start();

                // Read output
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                // Wait for process to complete
                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    System.out.println("WiFi hotspot turned on successfully.");

                    // Start a server socket to accept connections
                    ServerSocket serverSocket = new ServerSocket(6969); // Example port number
                    System.out.println("Server started on port 6969");

                    // Accept incoming connections
                    while (true) {
                        Socket clientSocket = serverSocket.accept();
                        System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                        // Handle client communication (e.g., read/write data)
                        // Example:
                        // BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        // PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        // String message = in.readLine();
                        // System.out.println("Received from client: " + message);
                    }
                } else {
                    System.out.println("Failed to turn on WiFi hotspot. Exit code: " + exitCode);
                }
            } else if (osName.contains("linux") || osName.contains("unix")) {
                // Execute nmcli command to turn on WiFi hotspot on Linux
                Process process = new ProcessBuilder("nmcli", "device", "wifi", "hotspot", "ssid", "MyHotspot", "password", "MyPassword").start();

                // Read output
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                // Wait for process to complete
                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    System.out.println("WiFi hotspot turned on successfully.");

                    // Start a server socket to accept connections
                    ServerSocket serverSocket = new ServerSocket(6969); // Example port number
                    System.out.println("Server started on port 6969");
                    DBMS.init();
                    // Accept incoming connections
                    while (true) {
                        Socket clientSocket = serverSocket.accept();
                        BasicClient basicClient = new BasicClient(clientSocket);
                        System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                        // Handle client communication (e.g., read/write data)
                        // Example:
                        // BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        // PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        // String message = in.readLine();
                        // System.out.println("Received from client: " + message);
                    }
                } else {
                    System.out.println("Failed to turn on WiFi hotspot. Exit code: " + exitCode);
                }
            } else {
                System.out.println("Unsupported operating system: " + osName);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
