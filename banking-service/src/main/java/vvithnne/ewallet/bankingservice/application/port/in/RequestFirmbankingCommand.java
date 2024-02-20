package vvithnne.ewallet.bankingservice.application.port.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import vvithnne.ewallet.common.constant.BankType;

import java.math.BigDecimal;

import static vvithnne.ewallet.common.validator.Validation.validate;

@Builder
public record RequestFirmbankingCommand(
        @NotNull BankType fromBank,

        @NotBlank String fromBankAccountNumber,

        @NotNull BankType toBank,

        @NotBlank String toBankAccountNumber,

        @NotNull BigDecimal moneyAmount
) {

    public RequestFirmbankingCommand(
            BankType fromBank,
            String fromBankAccountNumber,
            BankType toBank,
            String toBankAccountNumber,
            BigDecimal moneyAmount
    ) {
        this.fromBank = fromBank;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBank = toBank;
        this.toBankAccountNumber = toBankAccountNumber;
        this.moneyAmount = moneyAmount;
        validate(this);
    }

}
