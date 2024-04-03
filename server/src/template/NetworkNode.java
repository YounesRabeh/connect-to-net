package template;

import java.time.Duration;
import java.time.Instant;

public interface NetworkNode {

    String getIP();
    String getHostName();
    int getPortNumber();
    Instant getConnectionTime();
    ClientType getClientType();
    long getBytesSent();
    long getBytesReceived();
    Duration getConnectionDuration();
    String getUsername();
}

