package vvithnne.ewallet.bankingservice.application.port.out;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public record ExternalFirmbankingCommand(
        ExternalFirmbankingResultCode result
) {

    public static ExternalFirmbankingCommand of(ExternalFirmbankingResultCode result) {
        return new ExternalFirmbankingCommand(result);
    }

    @RequiredArgsConstructor
    @Getter
    public enum ExternalFirmbankingResultCode {

        SUCCEED(0), FAILED(1);

        private final int code;

    }

}
