package vvithnne.ewallet.bankingservice.application.port.out;

import vvithnne.ewallet.bankingservice.domain.RequestedFirmbanking;

public interface RegisterRequestedFirmbankingPort {

    RequestedFirmbanking createRequestedFirmbanking(RequestedFirmbanking requestedFirmbanking);

}
