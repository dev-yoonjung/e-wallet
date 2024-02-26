package vvithnne.ewallet.moneyservice.domain;

import lombok.NonNull;
import lombok.Value;

import java.time.Instant;

@Value
public class DateTime {

    public static DateTime NOW = DateTime.of(Instant.now());

    @NonNull Instant instant;

    public static DateTime of(Instant instant) {
        return new DateTime(instant);
    }

}
