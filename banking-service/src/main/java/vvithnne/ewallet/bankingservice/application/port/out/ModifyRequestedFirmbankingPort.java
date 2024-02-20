package vvithnne.ewallet.bankingservice.application.port.out;

import vvithnne.ewallet.bankingservice.domain.RequestedFirmbanking;
import vvithnne.ewallet.bankingservice.domain.RequestedFirmbanking.RequestedFirmbankingId;
import vvithnne.ewallet.bankingservice.domain.RequestedFirmbanking.FirmbankingStatus;

public interface ModifyRequestedFirmbankingPort {

    RequestedFirmbanking updateRequestedFirmbankingStatus(RequestedFirmbankingId id, FirmbankingStatus status);

}
