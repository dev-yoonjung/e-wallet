package vvithnne.ewallet.bankingservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import vvithnne.ewallet.bankingservice.adapter.out.persistence.entity.RequestedFirmbankingJpaEntity;
import vvithnne.ewallet.bankingservice.application.port.out.ModifyRequestedFirmbankingPort;
import vvithnne.ewallet.bankingservice.application.port.out.RegisterRequestedFirmbankingPort;
import vvithnne.ewallet.bankingservice.common.exception.NotFoundRegisteredFirmbankingException;
import vvithnne.ewallet.bankingservice.domain.RequestedFirmbanking;
import vvithnne.ewallet.common.annotation.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class RequestedFirmbankingPersistenceAdapter implements RegisterRequestedFirmbankingPort,
                                                               ModifyRequestedFirmbankingPort {

    private final RequestedFirmbankingMapper requestedFirmbankingMapper;

    private final SpringDataRequestedFirmbankingRepository requestedFirmbankingRepository;

    @Override
    public RequestedFirmbanking createRequestedFirmbanking(RequestedFirmbanking requestedFirmbanking) {
        RequestedFirmbankingJpaEntity entity = requestedFirmbankingRepository.save(
                requestedFirmbankingMapper.mapToJpaEntity(requestedFirmbanking)
        );

        return requestedFirmbankingMapper.mapToDomain(entity);
    }

    @Override
    public RequestedFirmbanking updateRequestedFirmbankingStatus(RequestedFirmbanking.RequestedFirmbankingId id,
                                                                 RequestedFirmbanking.FirmbankingStatus status
    ) {
        RequestedFirmbankingJpaEntity entity = requestedFirmbankingRepository.findById(id.getValue())
                .orElseThrow(NotFoundRegisteredFirmbankingException::new);

        entity.updateStatus(status.getCode());

        return requestedFirmbankingMapper.mapToDomain(entity);
    }
}
