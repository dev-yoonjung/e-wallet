package vvithnne.ewallet.bankingservice.application.port.in;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import vvithnne.ewallet.common.constant.BankType;

import static vvithnne.ewallet.common.validator.Validation.validate;

@Builder
public record RegisterBankAccountCommand(
        @NotNull Long membershipId,

        @NotNull BankType bankType,

        @NotBlank String bankAccountNumber

) {

    public RegisterBankAccountCommand(
            Long membershipId,
            BankType bankType,
            String bankAccountNumber
    ) {
        this.membershipId = membershipId;
        this.bankType = bankType;
        this.bankAccountNumber = bankAccountNumber;
        validate(this);
    }

}
