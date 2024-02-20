package vvithnne.ewallet.bankingservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import vvithnne.ewallet.bankingservice.adapter.out.persistence.entity.RequestedFirmbankingJpaEntity;

public interface SpringDataRequestedFirmbankingRepository extends JpaRepository<RequestedFirmbankingJpaEntity, Long> {
}
