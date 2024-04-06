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
            Socket socket = new Socket("localhost", 3215);
            System.out.println("Connected to server.");

            // Create input and output streams for communication
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStreamWriter output = new OutputStreamWriter(socket.getOutputStream());


            Thread.sleep(10000);
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
