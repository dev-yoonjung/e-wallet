package vvithnne.ewallet.moneyservice.application.port.in;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

import static vvithnne.ewallet.common.validator.Validation.validate;

@Builder
public record ChargeMoneyCommand(
        @NotNull Long membershipId,

        @NotNull BigDecimal amount
) {

    public ChargeMoneyCommand(
            Long membershipId,
            BigDecimal amount
    ) {
        this.membershipId = membershipId;
        this.amount = amount;
        validate(this);
    }

}
