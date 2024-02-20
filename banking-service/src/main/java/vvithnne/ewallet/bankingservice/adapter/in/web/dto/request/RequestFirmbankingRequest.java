package vvithnne.ewallet.bankingservice.adapter.in.web.dto.request;


import vvithnne.ewallet.bankingservice.application.port.in.RequestFirmbankingCommand;
import vvithnne.ewallet.common.constant.BankType;

import java.math.BigDecimal;

public record RequestFirmbankingRequest(
        String fromBankCode,

        String fromBankAccountNumber,

        String toBankCode,

        String toBankAccountNumber,

        BigDecimal moneyAmount
) {

    public RequestFirmbankingCommand toCommand() {
        return RequestFirmbankingCommand.builder()
                .fromBank(BankType.findBankTypeByCode(fromBankCode))
                .fromBankAccountNumber(fromBankAccountNumber)
                .toBank(BankType.findBankTypeByCode(toBankCode))
                .toBankAccountNumber(toBankAccountNumber)
                .moneyAmount(moneyAmount)
                .build();
    }

}
