package template;

import java.time.Duration;
import java.time.Instant;

public interface Connectable {
    String getIP();
    String getHostName();
    int getPortNumber();
    Instant getConnectionTime();
    long getBytesSent();
    long getBytesReceived();
    Duration getConnectionDuration();
}

