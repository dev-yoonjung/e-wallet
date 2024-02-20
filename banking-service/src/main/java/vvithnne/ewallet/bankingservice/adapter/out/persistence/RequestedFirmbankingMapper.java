package vvithnne.ewallet.bankingservice.adapter.out.persistence;

import org.springframework.stereotype.Component;
import vvithnne.ewallet.bankingservice.adapter.out.persistence.entity.RequestedFirmbankingJpaEntity;
import vvithnne.ewallet.bankingservice.domain.BankAccount.BankAccountNumber;
import vvithnne.ewallet.bankingservice.domain.Money;
import vvithnne.ewallet.bankingservice.domain.RequestedFirmbanking;
import vvithnne.ewallet.bankingservice.domain.RequestedFirmbanking.RequestedFirmbankingId;
import vvithnne.ewallet.bankingservice.domain.RequestedFirmbanking.FirmbankingStatus;

import java.util.Optional;

@Component
public class RequestedFirmbankingMapper {

    RequestedFirmbanking mapToDomain(RequestedFirmbankingJpaEntity requestedFirmbanking) {
        return RequestedFirmbanking.of(
                new RequestedFirmbankingId(requestedFirmbanking.getRquestedFirmbankingId()),
                requestedFirmbanking.getFromBank(),
                new BankAccountNumber(requestedFirmbanking.getFromBankAccountNumber()),
                requestedFirmbanking.getToBank(),
                new BankAccountNumber(requestedFirmbanking.getToBankAccountNumber()),
                Money.of(requestedFirmbanking.getMoneyAmount()),
                FirmbankingStatus.findFirmbankingStatusByCode(requestedFirmbanking.getFirmbankingStatus()),
                requestedFirmbanking.getUuid()
        );
    }

    RequestedFirmbankingJpaEntity mapToJpaEntity(RequestedFirmbanking requestedFirmbanking) {
        Long rquestedFirmbankingId = Optional.ofNullable(requestedFirmbanking.getRequestedFirmbankingId())
                .map(RequestedFirmbankingId::getValue)
                .orElse(null);

        return new RequestedFirmbankingJpaEntity(
                rquestedFirmbankingId,
                requestedFirmbanking.getFromBank(),
                requestedFirmbanking.getFromBankAccountNumber().getValue(),
                requestedFirmbanking.getToBank(),
                requestedFirmbanking.getToBankAccountNumber().getValue(),
                requestedFirmbanking.getMoneyAmount().getAmount(),
                requestedFirmbanking.getFirmbankingStatus().getCode(),
                requestedFirmbanking.getUuid().toString()
        );
    }

}
