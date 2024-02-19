package vvithnne.ewallet.bankingservice.adapter.in.web.dto.response;

import lombok.Builder;
import vvithnne.ewallet.bankingservice.domain.RegisteredBankAccount;

@Builder
public record RegisterBankAccountResponse(
        Long registeredBankAccountId,

        Long membershipId,

        String bankCode,

        String bankAccountNumber,

        boolean linkedStatusIsValid
) {

    public static RegisterBankAccountResponse of(RegisteredBankAccount registeredBankAccount) {
        return RegisterBankAccountResponse.builder()
                .registeredBankAccountId(registeredBankAccount.getRegisteredBankAccountId().getValue())
                .membershipId(registeredBankAccount.getRegisteredBankAccountId().getValue())
                .bankCode(registeredBankAccount.getBankType().getCode())
                .bankAccountNumber(registeredBankAccount.getBankAccountNumber().getValue())
                .linkedStatusIsValid(registeredBankAccount.getLinkedStatusIsValid().isValue())
                .build();
    }

}
