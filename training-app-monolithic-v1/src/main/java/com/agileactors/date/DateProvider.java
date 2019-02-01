package com.agileactors.date;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DateProvider {

    @Value("${application.timezone}")
    private String zoneId;


    public Instant now() {
        return Instant.now();
    }

    public ZonedDateTime zonedDateTimeNow() {
        return now().atZone(getZoneId());
    }

    public Clock getClock() {
        return Clock.system(getZoneId());
    }

    private ZoneId getZoneId() {
        return ZoneId.of(zoneId);
    }

    public ZonedDateTime toZonedDateTime(Instant instant) {
        if (instant == null) {
            return null;
        }
        return instant.atZone(getZoneId());
    }
}
