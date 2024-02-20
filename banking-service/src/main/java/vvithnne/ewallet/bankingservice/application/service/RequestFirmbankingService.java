package vvithnne.ewallet.bankingservice.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import vvithnne.ewallet.bankingservice.application.port.in.RequestFirmbankingCommand;
import vvithnne.ewallet.bankingservice.application.port.in.RequestFirmbankingUseCase;
import vvithnne.ewallet.bankingservice.application.port.out.ExternalFirmbankingCommand;
import vvithnne.ewallet.bankingservice.application.port.out.ModifyRequestedFirmbankingPort;
import vvithnne.ewallet.bankingservice.application.port.out.RegisterRequestedFirmbankingPort;
import vvithnne.ewallet.bankingservice.application.port.out.RequestExternalFirmbankingPort;
import vvithnne.ewallet.bankingservice.domain.BankAccount.BankAccountNumber;
import vvithnne.ewallet.bankingservice.domain.Money;
import vvithnne.ewallet.bankingservice.domain.RequestedFirmbanking;
import vvithnne.ewallet.bankingservice.domain.RequestedFirmbanking.FirmbankingStatus;
import vvithnne.ewallet.common.annotation.UseCase;

@UseCase
@Transactional
@RequiredArgsConstructor
public class RequestFirmbankingService implements RequestFirmbankingUseCase {

    private final RegisterRequestedFirmbankingPort registerRequestedFirmbankingPort;

    private final ModifyRequestedFirmbankingPort modifyRequestedFirmbankingPort;

    private final RequestExternalFirmbankingPort requestExternalFirmbankingPort;

    @Override
    public RequestedFirmbanking requestFirmbanking(RequestFirmbankingCommand command) {
        RequestedFirmbanking requestedFirmbanking = RequestedFirmbanking.of(
                command.fromBank(),
                new BankAccountNumber(command.fromBankAccountNumber()),
                command.toBank(),
                new BankAccountNumber(command.toBankAccountNumber()),
                Money.of(command.moneyAmount())
        );

        requestedFirmbanking = registerRequestedFirmbankingPort.createRequestedFirmbanking(requestedFirmbanking);

        ExternalFirmbankingCommand externalCommand = requestExternalFirmbankingPort.requestExternalFirmbanking(requestedFirmbanking);
        FirmbankingStatus status = switch (externalCommand.result()) {
                                        case SUCCEED -> FirmbankingStatus.COMPLETED;
                                        case FAILED -> FirmbankingStatus.FAILED;
                                    };

        return modifyRequestedFirmbankingPort.updateRequestedFirmbankingStatus(
                requestedFirmbanking.getRequestedFirmbankingId(),
                status
        );
    }

}
