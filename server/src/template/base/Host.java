package template.base;

import java.net.InetAddress;
import java.net.Socket;

public abstract class Host extends TimedDevice implements Connectable {
    // Upon Connected
    private final String IP, NAME;
    private final Integer PORT_NUM;

    // When Sending/receiving
    private long bytesSent;
    private long bytesReceived;

    
     Host(Socket socket){
         super();
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
    public long getBytesSent() { return bytesSent; }

    @Override
    public long getBytesReceived() { return bytesReceived; }



}
