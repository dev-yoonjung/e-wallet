package vvithnne.ewallet.moneyservice.domain;

import lombok.NonNull;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class Money {

    public static Money ZERO = Money.of(0L);

    @NonNull BigDecimal amount;

    public static Money of(Long value) {
        return new Money(BigDecimal.valueOf(value));
    }

    public static Money of(BigDecimal value) {
        return new Money(value);
    }
}
