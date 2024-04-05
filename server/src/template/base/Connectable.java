package template.base;


public interface Connectable {
    String getIP();

    String getName();

    int getPortNumber();

    long getBytesSent();

    long getBytesReceived();

    boolean isHostUp();
}

