package vvithnne.ewallet.bankingservice.application.port.in;

import vvithnne.ewallet.bankingservice.domain.RequestedFirmbanking;

public interface RequestFirmbankingUseCase {

    RequestedFirmbanking requestFirmbanking(RequestFirmbankingCommand command);

}
