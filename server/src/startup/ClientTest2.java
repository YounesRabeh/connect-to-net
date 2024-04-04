package startup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientTest2 {
    public static void main(String[] args) {
        try {
            // Connect to the server running on localhost at port 3214
            Socket socket = new Socket("localhost", 3214);
            System.out.println("Connected to server.");

            // Create input and output streams for communication
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream());

            // Send a message to the server
//            String message = "Hello, Server! im CLIENT 2";
//            output.write(message + "\n");
//            output.flush();
//            System.out.println("Sent message to server: " + message);
//
//            // Read the server's response
//            String response = input.readLine();
//            System.out.println("Server response: " + response);

            Thread.sleep(100000);
            // Close the socket and streams
            socket.close();
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
