package template.base;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface Timer {
    DateTimeFormatter CONNECTION_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy::HH:mm:ss");

    LocalDateTime getConnectionTime();

    Duration getConnectionDuration();

    String getFormattedConnectionTime();

    String getFormattedConnectionDuration();
}
