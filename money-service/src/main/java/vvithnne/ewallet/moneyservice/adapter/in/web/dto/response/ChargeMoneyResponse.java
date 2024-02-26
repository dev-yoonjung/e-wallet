package vvithnne.ewallet.moneyservice.adapter.in.web.dto.response;

import lombok.Builder;
import vvithnne.ewallet.moneyservice.domain.ChangingMoney;

import java.math.BigDecimal;

@Builder
public record ChargeMoneyResponse(
        Long changingId,

        BigDecimal amount,

        int result
) {

    public static ChargeMoneyResponse of(ChangingMoney changingMoney) {
        return ChargeMoneyResponse.builder()
                .changingId(changingMoney.getChangingId().getValue())
                .amount(changingMoney.getAmount().getAmount())
                .result(changingMoney.getChangingStatus().getCode())
                .build();
    }

}
