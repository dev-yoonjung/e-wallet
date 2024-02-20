package vvithnne.ewallet.bankingservice.adapter.out.external.bank.dto.request;

import vvithnne.ewallet.bankingservice.domain.RequestedFirmbanking;

public record ExternalFirmbankingRequest(
        String fromBankCode,

        String fromBankAccountNumber,

        String toBankCode,

        String toBankAccountNumber
) {

    public static ExternalFirmbankingRequest of(RequestedFirmbanking requestedFirmbanking) {
        return new ExternalFirmbankingRequest(
                requestedFirmbanking.getFromBank().getCode(),
                requestedFirmbanking.getFromBankAccountNumber().getValue(),
                requestedFirmbanking.getToBank().getCode(),
                requestedFirmbanking.getToBankAccountNumber().getValue()
        );
    }

}
