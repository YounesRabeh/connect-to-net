import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3214);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}