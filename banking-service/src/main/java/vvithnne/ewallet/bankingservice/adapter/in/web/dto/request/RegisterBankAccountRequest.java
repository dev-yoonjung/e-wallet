package vvithnne.ewallet.bankingservice.adapter.in.web.dto.request;

import vvithnne.ewallet.bankingservice.application.port.in.RegisterBankAccountCommand;
import vvithnne.ewallet.common.constant.BankType;

public record RegisterBankAccountRequest(
        Long membershipId,

        String bankCode,

        String bankAccountNumber
) {

    public RegisterBankAccountCommand toCommand() {
        return RegisterBankAccountCommand.builder()
                .membershipId(membershipId)
                .bankType(BankType.findBankTypeByCode(bankCode))
                .bankAccountNumber(bankAccountNumber)
                .build();
    }

}
