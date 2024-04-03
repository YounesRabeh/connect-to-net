package template;
import java.net.InetAddress;
import java.net.Socket;
import java.time.Duration;
import java.time.Instant;

public abstract class Client implements NetworkNode {
    // Upon Connected
    private final String IP, NAME;
    private final Integer PORT_NUM;
    private final Instant CONNECTION_TIME;
    private final ClientType CLIENT_TYPE;

    // When Sending/receiving
    private long bytesSent;
    private long bytesReceived;
    private Duration connectionDuration;

    // Custom
    private String username;

    public Client(Socket clientSocket) {
        InetAddress clientEndPoint = clientSocket.getInetAddress();

        this.IP              = clientEndPoint.getHostAddress();
        this.NAME            = clientEndPoint.getHostName();
        this.PORT_NUM        = clientSocket.getPort();
        this.CONNECTION_TIME = Instant.now();
        this.CLIENT_TYPE     = ClientType.BASIC; // default client type

        new ClientRecord(this, 1); // Assuming ClientRecord handles client record creation
    }

    //GETTERS:
    @Override
    public String getIP() { return IP; }

    @Override
    public String getHostName() { return NAME; }

    @Override
    public int getPortNumber() { return PORT_NUM; }

    @Override
    public Instant getConnectionTime() { return CONNECTION_TIME; }

    @Override
    public ClientType getClientType() { return CLIENT_TYPE; }

    @Override
    public long getBytesSent() { return bytesSent; }

    @Override
    public long getBytesReceived() { return bytesReceived; }

    @Override
    public Duration getConnectionDuration() { return connectionDuration; }

    @Override
    public String getUsername() { return username; }
}
