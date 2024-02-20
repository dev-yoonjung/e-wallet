package vvithnne.ewallet.bankingservice.adapter.in.web.dto.response;

import lombok.Builder;
import vvithnne.ewallet.bankingservice.domain.RequestedFirmbanking;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record RequestFirmbankingResponse(
        Long requestedFirmbankingId,

        String fromBankCode,

        String fromBankAccountNumber,

        String toBankCode,

        String toBankAccountNumber,

        BigDecimal moneyAmount,

        int firmbankingStatus,

        UUID uuid
) {

    public static RequestFirmbankingResponse of(RequestedFirmbanking requestedFirmbanking) {
        return RequestFirmbankingResponse.builder()
                .requestedFirmbankingId(requestedFirmbanking.getRequestedFirmbankingId().getValue())
                .fromBankCode(requestedFirmbanking.getFromBank().getCode())
                .fromBankAccountNumber(requestedFirmbanking.getFromBankAccountNumber().getValue())
                .toBankCode(requestedFirmbanking.getToBank().getCode())
                .toBankAccountNumber(requestedFirmbanking.getToBankAccountNumber().getValue())
                .moneyAmount(requestedFirmbanking.getMoneyAmount().getAmount())
                .firmbankingStatus(requestedFirmbanking.getFirmbankingStatus().getCode())
                .uuid(requestedFirmbanking.getUuid())
                .build();
    }

}
