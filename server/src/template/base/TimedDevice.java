package template.base;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class TimedDevice implements Timer {
    private final LocalDateTime CONNECTION_TIME;
    private final String CONNECTION_FORMATTED_TIME;
    private Duration connectionDuration;

    TimedDevice() {
        this.CONNECTION_TIME = LocalDateTime.now();
        this.CONNECTION_FORMATTED_TIME = CONNECTION_TIME.format(CONNECTION_TIME_FORMATTER);
        this.connectionDuration = Duration.ZERO;
    }

    private Duration calculateConnectionDuration() {
        return connectionDuration = Duration.between(CONNECTION_TIME, LocalDateTime.now());
    }

    @Override
    public LocalDateTime getConnectionTime() {
        return CONNECTION_TIME;
    }

    @Override
    public Duration getConnectionDuration() {
        return calculateConnectionDuration();
    }

    @Override
    public String getFormattedConnectionTime() {
        return CONNECTION_FORMATTED_TIME;
    }

    @Override
    public String getFormattedConnectionDuration() {
        calculateConnectionDuration();
        // Format the duration components
        long hours = connectionDuration.toHours();
        long minutes = connectionDuration.minusHours(hours).toMinutes();
        long seconds = connectionDuration.minusHours(hours).minusMinutes(minutes).getSeconds();

        // Construct the formatted string
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
