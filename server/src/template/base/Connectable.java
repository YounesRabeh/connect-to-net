package template.base;

import java.time.Duration;
import java.time.Instant;

public interface Connectable {
    String getIP();
    String getName();
    int getPortNumber();
    Instant getConnectionTime();
    long getBytesSent();
    long getBytesReceived();
    Duration getConnectionDuration();
}

