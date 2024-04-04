package template;

import java.net.InetAddress;
import java.net.Socket;
import java.time.Duration;
import java.time.Instant;

public abstract class Host implements Connectable {
    // Upon Connected
    private final String IP, NAME;
    private final Integer PORT_NUM;
    private final Instant CONNECTION_TIME;

    // When Sending/receiving
    private long bytesSent;
    private long bytesReceived;
    private Duration connectionDuration;
    
    protected Host(Socket socket){
        this.CONNECTION_TIME = Instant.now();

        InetAddress internet = socket.getInetAddress();
        this.PORT_NUM        = socket.getPort();
        this.IP              = internet.getHostAddress();
        this.NAME            = internet.getHostName();

    }

    //GETTERS:
    @Override
    public String getIP() { return IP; }

    @Override
    public String getName() { return NAME; }

    @Override
    public int getPortNumber() { return PORT_NUM; }

    @Override
    public Instant getConnectionTime() { return CONNECTION_TIME; }

    @Override
    public long getBytesSent() { return bytesSent; }

    @Override
    public long getBytesReceived() { return bytesReceived; }

    @Override
    public Duration getConnectionDuration() { return connectionDuration; }

}
