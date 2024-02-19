package vvithnne.ewallet.bankingservice.adapter.out.external.bank.dto.request;

import vvithnne.ewallet.bankingservice.domain.BankAccount;

public record GetBankAccountRequest(
        String bankCode,

        String bankAccountNumber
) {

    public static GetBankAccountRequest of(BankAccount bankAccount) {
        return new GetBankAccountRequest(
                bankAccount.getBankType().getCode(),
                bankAccount.getBankAccountNumber().getValue()
        );
    }

}
