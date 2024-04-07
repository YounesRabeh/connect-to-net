package template.base;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Objects;

public abstract class Host extends TimedDevice implements Connectable {
    // Upon Connected
    private final String IP, NAME;
    private final Integer PORT_NUM;

    // When Sending/receiving
    private long bytesSent;
    private long bytesReceived;

    private Socket SOCKET;

    Host(Socket socket) {
        super();
        this.SOCKET = socket;
        InetAddress internet = SOCKET.getInetAddress();
        this.PORT_NUM = SOCKET.getPort();
        this.IP = internet.getHostAddress();
        this.NAME = internet.getHostName();
    }

    //GETTERS:
    @Override
    public String getIP() {
        return IP;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getPortNumber() {
        return PORT_NUM;
    }

    @Override
    public long getBytesSent() {
        return bytesSent;
    }

    @Override
    public long getBytesReceived() {
        return bytesReceived;
    }

    @Override
    public boolean isHostUp() {
        if (SOCKET.isClosed()) {
            return false;
        }
        try {
            // Try to perform a small operation that won't affect the connection state
            this.SOCKET.sendUrgentData(0);
            return true; // If no exception is thrown, the connection is still alive
        } catch (IOException hostDown) { //TODO: custom 'unreachable' host
            return false; // Exception occurred, indicating a disconnection
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Host host)) return false;
        return Objects.equals(IP, host.IP) && Objects.equals(NAME, host.NAME) && Objects.equals(PORT_NUM, host.PORT_NUM) && Objects.equals(SOCKET, host.SOCKET);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IP, NAME, PORT_NUM, SOCKET);
    }
}
