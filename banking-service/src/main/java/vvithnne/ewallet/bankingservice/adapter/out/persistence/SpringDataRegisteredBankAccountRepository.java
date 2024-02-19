package vvithnne.ewallet.bankingservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import vvithnne.ewallet.bankingservice.adapter.out.persistence.entity.RegisteredBankAccountJpaEntity;

public interface SpringDataRegisteredBankAccountRepository extends JpaRepository<RegisteredBankAccountJpaEntity, Long> {
}
