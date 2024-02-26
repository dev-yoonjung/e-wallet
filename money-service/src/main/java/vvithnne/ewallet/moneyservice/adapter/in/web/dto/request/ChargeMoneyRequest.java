package vvithnne.ewallet.moneyservice.adapter.in.web.dto.request;

import vvithnne.ewallet.moneyservice.application.port.in.ChargeMoneyCommand;

import java.math.BigDecimal;

public record ChargeMoneyRequest(
        Long membershipId,

        BigDecimal amount
) {

    public ChargeMoneyCommand toCommand() {
        return ChargeMoneyCommand.builder()
                .membershipId(membershipId)
                .amount(amount)
                .build();
    }

}
